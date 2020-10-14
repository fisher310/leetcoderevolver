package p540;

import org.junit.Assert;

class Solution {
    public int singleNonDuplicate(int[] nums) {
        int lo = 0, hi = nums.length - 1;
        while (lo < hi) {
            int mid = lo + ((hi - lo) >> 1);
            boolean isEven = (hi - mid) % 2 == 0;
            if (nums[mid] == nums[mid + 1]) {
                if (isEven) {
                    lo = mid + 2;
                } else {
                    hi = mid - 1;
                }
            } else if (nums[mid] == nums[mid - 1]) {
                if (isEven) {
                    hi = mid - 2;
                } else {
                    lo = mid + 1;
                }
            } else {
                return nums[mid];
            }

        }
        return nums[lo];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        Assert.assertEquals(2, s.singleNonDuplicate(new int[]{1, 1, 2, 3, 3, 4, 4}));
        Assert.assertEquals(4, s.singleNonDuplicate(new int[]{1, 1, 3, 3, 4}));
        Assert.assertEquals(1, s.singleNonDuplicate(new int[]{1, 3, 3, 4, 4}));
    }
}
