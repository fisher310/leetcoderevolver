package m53;

/** 在排序数组中查找数字 I */
class Solution {
    public int search(int[] nums, int target) {
        int start = 0, end = nums.length;
        int count = 0;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                count = 1;
                int l = mid - 1, r = mid + 1;
                while (l >= 0 && nums[l] == target) {
                    count++;
                    l--;
                }
                while (r < nums.length && nums[r] == target) {
                    count++;
                    r++;
                }
                break;

            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }

        return count;
    }
}
