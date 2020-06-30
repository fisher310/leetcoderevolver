package p154;

class Solution {

    public int findMin(int[] nums) {

        int l = 0, r = nums.length - 1;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] < nums[r]) {
                r = mid;
            } else if (nums[mid] > nums[r]) {
                l = mid + 1;
            } else {
                r--;
            }
        }

        return nums[l];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.findMin(new int[] {1}));
        System.out.println(s.findMin(new int[] {1, 1, 1}));
        System.out.println(s.findMin(new int[] {3, 1, 3}));
        System.out.println(s.findMin(new int[] {2, 3, 4, 4, 5, 1, 2, 2}));
    }
}
