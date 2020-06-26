package p81;

/*
搜索旋转排序数组 II
 */
class Solution {

    public boolean search(int[] nums, int target) {
        if (null == nums || nums.length == 0) return false;

        int pos = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                pos = i;
                break;
            }
        }

        // 在pos处的是最小值
        if (target == nums[pos]) {
            return true;
        } else if (target < nums[pos]) {
            return false;
        } else if (target <= nums[nums.length - 1]) {
            return binarySearch(nums, pos + 1, nums.length, target);
        } else {
            return binarySearch(nums, 0, pos, target);
        }
    }

    private boolean binarySearch(int[] nums, int start, int end, int target) {
        int l = start;
        int r = end;

        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) {
                return true;
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return false;
    }
}
