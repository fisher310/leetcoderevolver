package p5;

/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *
 * <p>示例 1：
 *
 * <p>输入: "babad" 输出: "bab" 注意: "aba" 也是一个有效答案。 示例 2：
 *
 * <p>输入: "cbbd" 输出: "bb"
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {
  public String longestPalindrome(String s) {

    if (s == null || s.length() == 0) return "";

    char[] ch = s.toCharArray();
    int start = 0, end = 0;
    for (int i = 0; i < s.length(); i++) {
      int len1 = expandCenter(ch, i, i); // 奇数情况
      int len2 = expandCenter(ch, i, i + 1); // 偶数情况
      int len = Math.max(len1, len2);
      if (len > end - start) {
        start = i - (len - 1) / 2;
        end = i + (len) / 2;
      }
    }
    return s.substring(start, end + 1);
  }

  private int expandCenter(char[] ch, int lower, int higher) {
    while (lower >= 0 && higher < ch.length && ch[lower] == ch[higher]) {
      lower--;
      higher++;
    }
    return higher - lower - 1;
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    //    System.out.println(s.isPalindrome("abcba"));
    System.out.println(s.longestPalindrome("babad"));
    System.out.println(s.longestPalindrome("cbbd"));
    System.out.println(s.longestPalindrome("ac"));
  }
}
