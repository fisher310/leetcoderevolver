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

  private int wordLength;

  private int wordCount;
  private Map<String, Integer> tmpMap;

  public List<Integer> findSubstring(String s, String[] words) {
    if (s == null || s.length() == 0 || words == null || words.length == 0)
      return Collections.emptyList();

    wordCount = words.length;
    tmpMap = new HashMap<>(words.length);
    Map<String, Integer> wordMap = new HashMap<>();
    for (String word : words) {
      wordMap.put(word, wordMap.getOrDefault(word, 0) + 1);
    }

    List<Integer> ans = new LinkedList<>();
    this.wordLength = words[0].length();
    int totalLength = wordLength * words.length;
    for (int i = 0, N = s.length(); i <= N - totalLength; i++) {
      String sub = s.substring(i, i + totalLength);
      if (contains(sub, wordMap)) {
        ans.add(i);
      }
    }

    return ans;
  }

  private boolean contains(String s, Map<String, Integer> wordMap) {
    tmpMap.clear();
    int tmpCount = 0;
    for (int i = 0; i < s.length(); i += wordLength) {
      String word = s.substring(i, i + wordLength);
      if (wordMap.containsKey(word)) {
        int cnt = tmpMap.getOrDefault(word, 0) + 1;
        int totalCnt = wordMap.get(word);
        if (cnt > totalCnt) {
          return false;
        }
        tmpCount++;
        tmpMap.put(word, cnt);
      } else {
        return false;
      }
    }
    return tmpCount == wordCount;
  }
}
