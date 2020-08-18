package p1553;

import org.junit.Assert;

class Solution {


    public int minDays(int n) {

        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + 1;
            if (i % 2 == 0) {
                dp[i] = Math.min(dp[i], Math.min(dp[i - 1], dp[i / 2])) + 1;
            }

            if (i % 3 == 0) {
                dp[i] = Math.min(dp[i], Math.min(dp[i - 1], dp[i - 2 * (i / 3)])) + 1;
            }

        }
        return dp[n];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        Assert.assertEquals(8, s.minDays(182));
        Assert.assertEquals(4, s.minDays(10));
        Assert.assertEquals(3, s.minDays(6));
        Assert.assertEquals(1, s.minDays(1));
        Assert.assertEquals(6, s.minDays(56));
    }

}
