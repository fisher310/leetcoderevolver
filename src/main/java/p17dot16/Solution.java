package p17dot16;

import org.junit.Assert;
import org.junit.Test;

class Solution {
    public int message(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }

        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = nums[1];
        dp[2] = nums[2] + dp[0];

        for (int i = 3; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 2], dp[i - 3]) + nums[i];
        }

        return Math.max(dp[nums.length - 1], dp[nums.length - 2]);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        //        System.out.println(s.message(new int[]{1, 3, 2, 1}));

        //        assert 12 == s.message(new int[]{2, 7, 9, 3, 1});

        //        assert 4 == s.message(new int[]{2, 1, 1, 2});

        System.out.println(s.message(new int[]{1, 2, 3, 1}));
    }

    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(12, s.message(new int[]{2, 7, 9, 3, 1}));
    }
}
