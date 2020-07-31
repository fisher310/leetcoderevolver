package offer11;

import org.junit.Assert;

class Solution {

    public int minArray(int[] nums) {

        int N = nums.length - 1;
        int l = 0;
        int r = N;
        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (nums[mid] < nums[r]) {
                // 在左边
                r = mid;
            } else if (nums[mid] > nums[r]){
                l = mid + 1;
            } else {
                r--;
            }
        }
        return nums[l];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        Assert.assertEquals(1, s.minArray(new int[] {5,1,3}));
        Assert.assertEquals(1, s.minArray(new int[] {3, 1}));
        Assert.assertEquals(1, s.minArray(new int[] {3, 1, 1}));
        Assert.assertEquals(1, s.minArray(new int[] {1}));
        Assert.assertEquals(1, s.minArray(new int[] {1, 1}));
        Assert.assertEquals(1, s.minArray(new int[] {3, 4, 5, 1, 2}));
        Assert.assertEquals(1, s.minArray(new int[] {1, 1, 3, 4, 5, 1, 1}));
        Assert.assertEquals(1, s.minArray(new int[] {2, 3, 4, 5, 1, 2}));
        Assert.assertEquals(1, s.minArray(new int[] {1, 3, 4, 5, 1, 1}));
    }
}
