package p474;

// m of 0  n of 1

import org.junit.Assert;

// dp[i][0] =
// dp[i][1]
class Solution {
    public int findMaxForm(String[] strs, int m, int n) {

        int[][][] dp = new int[strs.length + 1][m + 1][n + 1];

        for (int i = 1; i <= strs.length; i++) {
            String s = strs[i - 1];
            int x0 = 0;
            int x1 = 0;
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == '0') x0++;
                else x1++;
            }
            for (int u = 0; u <= m; u++) {
                for (int v = 0; v <= n; v++) {
                    if (u < x0 || v < x1) {
                        dp[i][u][v] = dp[i - 1][u][v];
                    } else {
                        dp[i][u][v] = Math.max(dp[i - 1][u][v], dp[i - 1][u - x0][v - x1] + 1);
                    }
                }
            }
        }

        return dp[strs.length][m][n];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        Assert.assertEquals(2, s.findMaxForm(new String[] {"10", "0", "1"}, 1, 1));
        Assert.assertEquals(
                4, s.findMaxForm(new String[] {"10", "0001", "111001", "1", "0"}, 5, 3));
    }
}
