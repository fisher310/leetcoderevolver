package p1567;

import org.junit.Assert;

class Solution {

    public int getMaxLen(int[] nums) {

        int p = nums[0] > 0 ? 1 : 0;
        int n = nums[0] < 0 ? 1 : 0;

        int result = p;
        for (int i = 1; i < nums.length; i++) {
            int pp = p;
            int pn = n;
            if (nums[i] > 0) {
                p = pp + 1;
                n = pn > 0 ? pn + 1 : 0;
            } else if (nums[i] < 0) {
                p = pn > 0 ? pn + 1 : 0;
                n = pp + 1;
            } else {
                p = 0;
                n = 0;
            }

            result = Math.max(result, p);
        }

        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        Assert.assertEquals(8, s.getMaxLen(new int[]{5, -20, -20, -39, -5, 0, 0, 0, 36, -32, 0, -7, -10, -7, 21, 20, -12, -34, 26, 2}));
        Assert.assertEquals(1, s.getMaxLen(new int[]{-1, 2}));
        Assert.assertEquals(3, s.getMaxLen(new int[]{0, 1, -2, -3, -4}));
        Assert.assertEquals(4, s.getMaxLen(new int[]{1, -2, -3, 4}));
        Assert.assertEquals(2, s.getMaxLen(new int[]{-1, -2, -3, 0, 1}));
    }
}

