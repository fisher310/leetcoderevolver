package p714;

import org.junit.Assert;

class Solution {

    public int maxProfit(int[] prices, int fee) {
        if (prices == null || prices.length <= 1) return 0;
        int dp_i_0 = 0;
        int dp_i_1 = Integer.MIN_VALUE;

        for (int i = 0; i < prices.length; i++) {
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
            dp_i_1 = Math.max(dp_i_1, dp_i_0 - prices[i] - fee);
        }
        return dp_i_0;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        Assert.assertEquals(6, s.maxProfit(new int[]{1, 3, 7, 5, 10, 3}, 3));
        Assert.assertEquals(8, s.maxProfit(new int[]{1, 3, 2, 8, 4, 9}, 2));
    }
}
