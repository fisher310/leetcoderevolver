package p33;

/** 搜索旋转排序数组 */
class Solution {

    public int search(int[] nums, int target) {

        if (nums == null || nums.length == 0) return -1;

        int l = 0, r = nums.length, last = nums[nums.length - 1];

        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] <= last) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }

        // l 是旋转位置
        if (nums[l] == target) {
            return l;
        } else if (nums[l] > target) {
            return -1;
        } else if (last < target) {
            // 在左边找
            r = l;
            l = 0;
        } else {
            // 在右边找
            r = nums.length;
        }

        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.search(new int[]{1,2,3,4}, 3));
        int[] input = {4, 5, 6, 7, 0, 1, 2};
        System.out.println(s.search(input, 0));

        System.out.println(s.search(input, 3));
    }
}
