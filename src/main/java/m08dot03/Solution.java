package m08dot03;

import org.junit.Assert;

class Solution {

    public int findMagicIndex(int[] nums) {
        return doGetMagic(nums, 0, nums.length - 1);
    }

    private int doGetMagic(int[] nums, int left, int right) {
        if (left > right) {
            return -1;
        }
        int mid = left + (right - left) / 2;
        int la = doGetMagic(nums, left, mid - 1);
        if (la != -1) {
            return la;
        } else if (nums[mid] == mid) {
            return mid;
        }
        return doGetMagic(nums, mid + 1, right);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        Assert.assertEquals(
                32,
                s.findMagicIndex(
                        new int[] {
                            32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32,
                            32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32,
                            32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32,
                            32, 32, 32, 32, 32, 32, 32, 32, 32, 32
                        }));
        Assert.assertEquals(0, s.findMagicIndex(new int[] {0, 2, 3, 4, 5}));
        Assert.assertEquals(1, s.findMagicIndex(new int[] {1, 1, 1}));
    }
}
