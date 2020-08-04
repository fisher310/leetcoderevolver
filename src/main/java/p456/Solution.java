package p456;

import org.junit.Assert;

import java.util.LinkedList;

class Solution {

    public boolean find132pattern(int[] nums) {
        if (nums == null || nums.length == 0) return false;

        int[] min = new int[nums.length];

        min[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            min[i] = Math.min(nums[i], min[i - 1]);
        }

        LinkedList<Integer> stack = new LinkedList<>();
        for (int j = nums.length - 1; j >= 0; j--) {
            if (nums[j] == min[j]) continue;
            while (!stack.isEmpty() && stack.peek() <= min[j]) {
                stack.pop();
            }
            if (!stack.isEmpty() && nums[j] > stack.peek() && stack.peek() > min[j]) {
                return true;
            }

            if (nums[j] > min[j]) stack.push(nums[j]);
        }

        return false;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        Assert.assertTrue(s.find132pattern(new int[] {3, 5, 0, 3, 4}));
        Assert.assertTrue(s.find132pattern(new int[] {3, 1, 4, 2, 4}));
        Assert.assertTrue(s.find132pattern(new int[] {-1, 3, 2, 0}));
        Assert.assertFalse(s.find132pattern(new int[] {1, 2, 3, 4}));
    }
}
