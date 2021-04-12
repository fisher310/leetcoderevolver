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

        int l = 0, r = n - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] > nums[mid + 1]) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}
