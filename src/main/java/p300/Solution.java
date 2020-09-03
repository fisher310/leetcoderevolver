package p300;

import org.junit.Assert;

import java.util.Arrays;

class Solution {

    public int lengthOfLIS(int[] nums) {

        if (nums == null || nums.length == 0) return 0;

        int[] dp = new int[nums.length];

        int ans = 1;
        Arrays.fill(dp, 1);
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j <= i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }

            ans = Math.max(ans, dp[i]);
        }

        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        Assert.assertEquals(4, s.lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
        Assert.assertEquals(1, s.lengthOfLIS(new int[]{0}));
        Assert.assertEquals(0, s.lengthOfLIS(new int[]{}));
    }
}
