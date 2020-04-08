package p283;

import java.util.Arrays;

/** 移动零 */
class Solution {
  public void moveZeroes(int[] nums) {
    int k = 0;
    int N = nums.length;
    for (int i = 0; i < N; i++) {
      if (nums[i] != 0) {
        if (i != k) {
          int tmp = nums[k];
          nums[k] = nums[i];
          nums[i] = tmp;
        }
        k++;
      }
    }
  }

  public static void main(String[] args) {
    int[] nums = new int[] {0, 1, 0, 3, 12};
    Solution s = new Solution();
    s.moveZeroes(nums);
    System.out.println(Arrays.toString(nums));
  }
}
