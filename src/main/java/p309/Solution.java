package p309;

import org.junit.Assert;

/**
 * 卖出后无法在第二天买入, 冷冻期1天
 */
class Solution {

    public int maxProfit(int[] prices) {
        if (prices.length <= 1) return 0;
        int dp_i_0 = 0;
        int dp_i_1 = Integer.MIN_VALUE;
        int pre_0 = 0;

        for (int i = 0; i < prices.length; i++) {
            int temp = dp_i_0;
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
            dp_i_1 = Math.max(dp_i_1, pre_0 - prices[i]);
            pre_0 = temp;
        }
        return dp_i_0;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        Assert.assertEquals(3, s.maxProfit(new int[]{1, 2, 3, 0, 2}));
    }
}
