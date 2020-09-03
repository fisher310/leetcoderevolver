package p1558;

import org.junit.Assert;

class Solution {

    public int minOperations(int[] nums) {

        int ops = 0;

        boolean flag = false;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                if (nums[i] == 1) {
                    ops++;
                    nums[i]--;
                } else if (nums[i] % 2 == 1) {
                    ops++;
                    nums[i] = (nums[i] - 1) / 2;
                    flag = true;
                } else {
                    flag = true;
                    nums[i] /= 2;
                }
            }
        }
        if (flag) {
            ops++;
        }

        if (ops > 0) {
            return ops + minOperations(nums);
        }
        return 0;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        Assert.assertEquals(8, s.minOperations(new int[]{2, 4, 8, 16}));
        Assert.assertEquals(7, s.minOperations(new int[]{3, 2, 2, 4}));
        Assert.assertEquals(5, s.minOperations(new int[]{1, 5}));
        Assert.assertEquals(6, s.minOperations(new int[]{4, 2, 5}));
        Assert.assertEquals(3, s.minOperations(new int[]{2, 2}));
        Assert.assertEquals(3, s.minOperations(new int[]{2, 2}));
    }
}
