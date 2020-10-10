package p72;

import org.junit.Assert;

class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = i;
        }

        for (int j = 0; j <= m; j++) {
            dp[0][j] = j;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (word1.charAt(i) == word2.charAt(j)) {
                    dp[i + 1][j + 1] =
                            Math.min(dp[i][j] - 1, Math.min(dp[i][j + 1], dp[i + 1][j])) + 1;
                } else {
                    dp[i + 1][j + 1] = Math.min(dp[i][j], Math.min(dp[i + 1][j], dp[i][j + 1])) + 1;
                }
            }
        }

        return dp[n][m];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        Assert.assertEquals(5, s.minDistance("intention", "execution"));
        Assert.assertEquals(3, s.minDistance("horse", "ros"));
    }
}
