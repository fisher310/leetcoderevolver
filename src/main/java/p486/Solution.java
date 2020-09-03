package p486;

import org.junit.Assert;

class Solution {
    public boolean PredictTheWinner(int[] nums) {
        return dfs(nums, 0, nums.length - 1, 1) > 0;
    }

    private int dfs(int[] nums, int start, int end, int turn) {
        if (start == end) {
            return nums[start] * turn;
        }

        int startScore = nums[start] * turn + dfs(nums, start + 1, end, -turn);
        int endScore = nums[end] * turn + dfs(nums, start, end - 1, -turn);
        return Math.max(startScore * turn, endScore * turn) * turn;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        Assert.assertFalse(s.PredictTheWinner(new int[]{1, 5, 2}));
        Assert.assertTrue(s.PredictTheWinner(new int[]{1, 5, 233, 7}));
    }
}
