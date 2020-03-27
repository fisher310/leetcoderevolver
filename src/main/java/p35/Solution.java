package p35;

/**
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 *
 * <p>你可以假设数组中无重复元素。
 *
 * <p>示例 1:
 *
 * <p>输入: [1,3,5,6], 5 输出: 2 示例 2:
 *
 * <p>输入: [1,3,5,6], 2 输出: 1 示例 3:
 *
 * <p>输入: [1,3,5,6], 7 输出: 4 示例 4:
 *
 * <p>输入: [1,3,5,6], 0 输出: 0
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/search-insert-position
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {
    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;

        return search(nums, 0, nums.length - 1, target);
    }

    private int search(int[] nums, int left, int right, int target) {
        if (left == right) {
            if (left == nums.length - 1 && nums[left] < target) {
                return left + 1;
            }
            return left;
        }
        int mid = (left + right) / 2;
        if (nums[mid] == target) {
            return mid;
        } else if (nums[mid] > target) {
            return search(nums, left, mid, target);
        } else {
            return search(nums, mid + 1, right, target);
        }
    }
}
