package p34;

/**
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 *
 * <p>你的算法时间复杂度必须是 O(log n) 级别。
 *
 * <p>如果数组中不存在目标值，返回 [-1, -1]。
 *
 * <p>示例 1:
 *
 * <p>输入: nums = [5,7,7,8,8,10], target = 8 输出: [3,4] 示例 2:
 *
 * <p>输入: nums = [5,7,7,8,8,10], target = 6 输出: [-1,-1]
 *
 * <p>来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {
    private int start = -1, end = -1;

    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }
        search(nums, 0, nums.length - 1, target);
        return new int[]{start, end};
    }

    private void search(int[] nums, int left, int right, int target) {
        if (left == right) {
            if (nums[left] == target) {
                start = left;
                end = left;
            } else {
                start = -1;
                end = -1;
            }
            return;
        }

        int mid = (left + right) / 2;
        if (nums[mid] == target) {
            int l = mid;
            int r = mid;
            while (l >= 0 && nums[l] == target) {
                l--;
            }
            start = l + 1;
            while (r < nums.length && nums[r] == target) {
                r++;
            }
            end = r - 1;
        } else if (nums[mid] < target) {
            search(nums, mid + 1, right, target);
        } else {
            search(nums, left, mid, target);
        }
    }
}
