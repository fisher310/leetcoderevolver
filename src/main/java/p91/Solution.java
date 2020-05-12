package p91;

/** 解码方法 */
class Solution {
  public int numDecodings(String s) {
    int len = s.length();
    int[] dp = new int[len];
    dp[0] = s.charAt(0) == '0' ? 0 : 1;
    if (len == 1 || dp[0] == 0) return dp[0];
    char c1 = s.charAt(1);
    if (c1 == 0) {
      dp[1] = 1;
      dp[0] = 0;
    }
    for (int i = 2; i < len; i++) {
      char c = s.charAt(i);
      if (c == '0') {
        if (s.charAt(i - 1) == '1' || s.charAt(i - 1) == '2') {
          dp[i] = dp[i - 2];
        } else {
          return 0;
        }
      } else {
      }
    }
    return dp[len - 1];
  }
}
