package p125;

import java.util.ArrayList;
import java.util.List;

/**
 * 验证回文串 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 *
 * <p>说明：本题中，我们将空字符串定义为有效的回文串。
 *
 * <p>示例 1:
 *
 * <p>输入: "A man, a plan, a canal: Panama" 输出: true 示例 2:
 *
 * <p>输入: "race a car" 输出: false
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/valid-palindrome
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {
  public boolean isPalindrome(String s) {
    if (s == null || s.trim().length() == 0) return true;

    s = s.toLowerCase();
    List<Character> list = new ArrayList<>(s.length());
    for (int i = 0, N = s.length(); i < N; i++) {
      char c = s.charAt(i);
      if (('0' <= c && c <= '9') || ('a' <= c && c <= 'z')) {
        list.add(c);
      }
    }
    for (int i = 0, j = list.size() - 1; i < j; i++, j--) {
      if (list.get(i) != list.get(j)) {
        return false;
      }
    }

    return true;
  }
}
