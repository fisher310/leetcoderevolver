package p343;

import org.junit.Assert;

class Solution {

    public int integerBreak(int n) {
        if (n == 2) return 1;
        if (n == 3) return 2;

        int[] dp = new int[n + 1];
        dp[2] = 2;
        dp[3] = 3;
        for (int i = 4; i <= n; i++) {
            dp[i] = Math.max(dp[i - 2] * 2, dp[i - 3] * 3);
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        Assert.assertEquals(1, s.integerBreak(2));
        Assert.assertEquals(36, s.integerBreak(10));
        Assert.assertEquals(81, s.integerBreak(12));
        Assert.assertEquals(2125764, s.integerBreak(40));
    }
}
