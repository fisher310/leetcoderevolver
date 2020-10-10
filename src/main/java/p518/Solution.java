package p518;

import org.junit.Assert;

class Solution {

    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int i = 0; i < coins.length; i++) {
            for (int x = coins[i]; x <= amount; x++) {
                dp[x] += dp[x - coins[i]];
            }
        }
        return dp[amount];
//        int[] dp = new int[amount + 1];
//        dp[0] = 1;
//        for (int coin : coins) {
//            for (int x = coin; x < amount + 1; x++) {
//                dp[x] += dp[x - coin];
//            }
//        }
//
//        return dp[amount];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        Assert.assertEquals(4, s.change(4, new int[] {1, 2, 3}));
    }
}
