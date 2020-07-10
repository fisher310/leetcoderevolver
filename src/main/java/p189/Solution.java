package p189;

import java.util.Arrays;

class Solution {

  public void rotate(int[] nums, int k) {
    int N = nums.length;

    k = k % N;

    reverse(nums, 0, N);
    reverse(nums, 0, k);
    reverse(nums, k, N);
  }

  private void reverse(int[] nums, int start, int end) {
    int l = start;
    int r = end - 1;
    while (l < r) {
      int temp = nums[l];
      nums[l] = nums[r];
      nums[r] = temp;
      l++;
      r--;
    }
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    int[] nums = new int[] {1, 2, 3, 4, 5, 6, 7};
    s.rotate(nums, 3);
    System.out.println(Arrays.toString(nums));
  }
}
