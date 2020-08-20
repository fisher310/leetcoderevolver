package p123;

class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length <=1) return 0;
        int maxK = 2;
        int[][][] dp = new int[prices.length][maxK + 1][2];
        for (int i = 0; i < prices.length; i++) {
            for (int k = maxK; k >= 1; k--) {
                if (i - 1 == -1) {
                    dp[i][k][1] = -prices[0];
                    dp[i][k][0] = 0;
                } else {
                    dp[i][k][0] = Math.max(dp[i - 1][k][0], dp[i - 1][k][1] + prices[i]);
                    dp[i][k][1] = Math.max(dp[i - 1][k][1], dp[i - 1][k - 1][0] - prices[i]);
                }
                print(dp);
            }
        }

        return dp[prices.length - 1][maxK][0];
    }

    void print(int[][][] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[i].length; j++) {
                System.out.print("[");
                for (int k = 0; k < nums[i][j].length; k++) {
                    System.out.print(nums[i][j][k] + ", ");
                }
                System.out.println("]");
            }
            System.out.println();
        }
        System.out.println("--------------------------");
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.maxProfit(new int[]{1, 2, 3, 4, 5}));
//        System.out.println(s.maxProfit(new int[]{3, 3, 5, 0, 0, 3, 1, 4}));
    }


}
