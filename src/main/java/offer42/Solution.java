package offer42;

import org.junit.Assert;

class Solution {

    public int maxSubArray(int[] nums) {

        int a = nums[0], max = nums[0];

        for (int i = 1; i < nums.length; i++) {
            a = Math.max(a, 0) + nums[i];
            if (a > max) max = a;
        }

        return max;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        Assert.assertEquals(6, s.maxSubArray(new int[] {-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }
}
