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
    String result = "";
    int[] limit = {0, 0};
    char[] ch = s.toCharArray();
    int i = 0;
    while (i < ch.length) {
      i = indexOf(ch, i, limit);
    }
    result = s.substring(limit[0], limit[1]);
    return result;
  }

  public int indexOf(char[] ch, int low, int[] limit) {
    int high = low + 1;
    while (high < ch.length && ch[high] == ch[low]) {
      high++;
    }
    int result = high;
    while (low > 0 && high < ch.length && ch[low - 1] == ch[high]) {
      low--;
      high++;
    }

    if (high - low > limit[1] - limit[0]) {
      limit[0] = low;
      limit[1] = high;
    }
    return result;
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    //    System.out.println(s.isPalindrome("abcba"));
    System.out.println(s.longestPalindrome("babad"));
    System.out.println(s.longestPalindrome("cbbd"));
    System.out.println(s.longestPalindrome("ac"));
  }
}
