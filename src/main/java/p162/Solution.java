package p162;

/**
 * -∞ [1,2,3,1] -∞
 *
 * @author lihailong
 * @since 2021/04/12 10:46:00
 */
class Solution {

    public int findPeakElement(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                return i;
            }
        }
        return n - 1;
    }
}
