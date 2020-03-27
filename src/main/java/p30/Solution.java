package p30;

import java.util.*;

/**
 * 给定一个字符串 s 和一些长度相同的单词 words。找出 s 中恰好可以由 words 中所有单词串联形成的子串的起始位置。
 *
 * <p>注意子串要与 words 中的单词完全匹配，中间不能有其他字符，但不需要考虑 words 中单词串联的顺序。
 *
 * <p>
 *
 * <p>示例 1：
 *
 * <p>输入： s = "barfoothefoobarman", words = ["foo","bar"] 输出：[0,9] 解释： 从索引 0 和 9 开始的子串分别是 "barfoo" 和
 * "foobar" 。 输出的顺序不重要, [9,0] 也是有效答案。 示例 2：
 *
 * <p>输入： s = "wordgoodgoodgoodbestword", words = ["word","good","best","word"] 输出：[]
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/substring-with-concatenation-of-all-words
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {

    private Set<Integer> ans = new HashSet<>();
    private Map<String, List<Integer>> map = new HashMap<>();

    public List<Integer> findSubstring(String s, String[] words) {
        if (s == null || s.length() == 0 || words == null || words.length == 0)
            return Collections.emptyList();

        int wordLength = words[0].length();
        for (int i = 0; i < words.length; i++) {
            if (map.containsKey(words[i])) {
                map.get(words[i]).add(i);
            } else {
                List<Integer> l = new ArrayList<>();
                l.add(i);
                map.put(words[i], l);
            }
        }
        int idx0 = s.indexOf(words[0]);


        outer:
        for (; idx0 >= 0; idx0 = s.indexOf(words[0], idx0 + wordLength)) {
            int l = idx0;
            int r = idx0;
            int[] visited = new int[words.length];
            visited[0] = 1;
            while ((l - wordLength) >= 0) {
                l -= wordLength;
                String ls = s.substring(l, l + wordLength);
                List<Integer> wordIndexes = map.get(ls);
                if (null == wordIndexes) {
                    l += wordLength;
                    break;
                } else {
                    int alreadyVisited = 0;
                    for (int wordIndex : wordIndexes) {
                        if (visited[wordIndex] == 1) {
                            alreadyVisited++;
                        } else {
                            visited[wordIndex] = 1;
                            break;
                        }
                    }
                    if (alreadyVisited == wordIndexes.size()) {
                        l += wordLength;
                        break;
                    }
                }
            }

            while ((r + wordLength) < s.length()) {
                r += wordLength;
                String rs = s.substring(r, r + wordLength);
                List<Integer> wordIndexes = map.get(rs);
                if (null == wordIndexes) {
                    r -= wordLength;
                    break;
                } else {
                    int alreadyVisited = 0;
                    for (int wordIndex : wordIndexes) {
                        if (visited[wordIndex] == 1) {
                            alreadyVisited++;
                        } else {
                            visited[wordIndex] = 1;
                            break;
                        }
                    }
                    if (alreadyVisited == wordIndexes.size()) {
                        r -= wordLength;
                        break;
                    }
                }
            }

            for (int vi : visited) {
                if (vi == 0) {
                    continue outer;
                }
            }
            ans.add(l);
        }

        return new ArrayList<>(ans);
    }

}
