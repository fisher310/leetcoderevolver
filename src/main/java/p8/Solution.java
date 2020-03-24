package p8;

/**
 *
 */
class Solution {
  public int myAtoi(String str) {
    if (null == str) {
      return 0;
    }
    str = str.trim();
    if (str.length() == 0) {
      return 0;
    }
    char[] s = str.toCharArray();

    int sign = 1;
    int start = 0;
    if (s[0] == '+') {
      sign = 1;
      start = 1;
    } else if (s[0] == '-') {
      sign = -1;
      start = 1;
    }

    long ans = 0;
    for (; start < s.length; start++) {
      if (s[start] >= '0' && s[start] <= '9') {
        ans = ans * 10 + s[start] - 48;
        if (sign == 1 && ans > Integer.MAX_VALUE) {
          return Integer.MAX_VALUE;
        } else if (sign == -1 && -ans < Integer.MIN_VALUE) {
          return Integer.MIN_VALUE;
        }
      } else {
        break;
      }
    }
    return (int) ans * sign;
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println(s.myAtoi("   -42"));
    System.out.println(s.myAtoi("4193 with words"));
    System.out.println(s.myAtoi("words and 987"));
    System.out.println(s.myAtoi("-91283472332"));
  }
}
