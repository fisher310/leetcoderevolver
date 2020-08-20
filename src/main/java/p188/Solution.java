package p188;

class Solution {

    public int maxProfit(int k, int[] prices) {
        if (prices.length <= 1) return 0;
        if (k > prices.length / 2) {
            int[][] dp = new int[prices.length][2];
            for (int i = 0; i < prices.length; i++) {
                if (i == 0) {
                    dp[i][0] = 0;
                    dp[i][1] = -prices[i];
                } else {
                    dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]);
                    dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] - prices[i]);
                }
            }
            return dp[prices.length-1][0];
        } else {
            int[][][] dp = new int[prices.length][k + 1][2];

            for (int i = 0; i < prices.length; i++) {
                for (int j = k; j >= 1; j--) {
                    if (i - 1 == -1) {
                        dp[i][j][0] = 0;
                        dp[i][j][1] = -prices[i];
                    } else {
                        dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);
                        dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i]);
                    }
                }
            }
            return dp[prices.length - 1][k][0];
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.maxProfit(2, new int[]{2, 4, 1}));
        System.out.println(s.maxProfit(2, new int[]{3, 2, 6, 5, 0, 3}));
    }
}
