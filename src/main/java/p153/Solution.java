package p153;

class Solution {

    public int findMin(int[] nums) {

        int l = 0;
        int r = nums.length;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] <= nums[nums.length - 1]) {
                // 在左边
                r = mid;
            } else if (nums[mid] > nums[nums.length - 1]) {
                // 在右边
                l = mid + 1;
            }
        }

        return nums[l];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.findMin(new int[] {3, 4, 5, 6, 7, 1, 2}));
        System.out.println(s.findMin(new int[] {1, 2, 3, 4, 5, 6, 7}));
        System.out.println(s.findMin(new int[] {6, 1, 2, 3, 4, 5}));
    }
}
