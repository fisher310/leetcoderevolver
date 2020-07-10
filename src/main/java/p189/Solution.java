package p189;

import java.util.Arrays;

class Solution {

  public void roate(int[] nums, int k) {
    int N = nums.length;

    k = k % N;

    int[] temp = new int[N];
    System.arraycopy(nums, N - k, temp, 0, k);
    //    for (int i = 0; i < k; i++) {
    //      temp[i] = nums[N - k + i];
    //    }

    System.arraycopy(nums, 0, temp, k, N - k);
    //    for (int i = k; i < N; i++) {
    //      temp[i] = nums[i - k];
    //    }
    System.arraycopy(temp, 0, nums, 0, N);
  }

  private void swap(int[] nums, int i, int j) {
    int tmp = nums[i];
    nums[i] = nums[j];
    nums[j] = tmp;
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    int[] nums = new int[] {1, 2, 3, 4, 5, 6, 7};
    s.roate(nums, 3);
    System.out.println(Arrays.toString(nums));
  }
}
