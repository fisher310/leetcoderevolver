package p3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * <p>示例 1:
 *
 * <p>输入: "abcabcbb" 输出: 3 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。 示例 2:
 *
 * <p>输入: "bbbbb" 输出: 1 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。 示例 3:
 *
 * <p>输入: "pwwkew" 输出: 3 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。   请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 * <p>来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {
  public int lengthOfLongestSubstring(String s) {

    int ans = 0;
    int n = s.length();
    Set<Character> set = new HashSet<>();
    int i = 0, j = 0;
    while (i < n && j < n) {
      if (!set.contains(s.charAt(j))) {
        set.add(s.charAt(j++));
        ans = Math.max(ans, j - i);
      } else {
        set.remove(s.charAt(i++));
      }
    }
    return ans;
  }

  public static void main(String[] args) {
    Map<String, Integer> testCases = new HashMap<>();
    testCases.put("abcabc", 3);
    testCases.put("pwwkew", 3);
    testCases.put("pwwkekabcdfglmw", 11);
    testCases.put(" ", 1);
    testCases.put("abcdefg", 7);
    testCases.put("aab", 2);

    Solution s = new Solution();
    for (Map.Entry<String, Integer> e : testCases.entrySet()) {
      int ans = s.lengthOfLongestSubstring(e.getKey());
      if (ans != e.getValue()) {
        System.err.println(
            String.format("error: for %s expected: %d, but get %d", e.getKey(), e.getValue(), ans));
      }
    }
  }
}
