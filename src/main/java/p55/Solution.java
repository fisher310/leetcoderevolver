package p55;

import org.junit.Assert;

/** 跳跃游戏 */
class Solution {
    public boolean canJump(int[] nums) {

        int max = nums[0];
        int i = 0;
        for (int j = 1; j <= max && j < nums.length; j++) {
            max = Math.max(max, j + nums[j]);
        }
        return max >= nums.length - 1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        Assert.assertTrue(s.canJump(new int[] {1, 2, 3}));
        Assert.assertTrue(s.canJump(new int[] {2, 5, 0, 0}));
        Assert.assertTrue(s.canJump(new int[] {2, 3, 1, 1, 4}));
        Assert.assertFalse(s.canJump(new int[] {3, 2, 1, 0, 4}));
    }
}
