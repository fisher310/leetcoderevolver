package p75;

/** 颜色分类 三路快排思路 */
class Solution {
  public void sortColors(int[] nums) {
    int zero = 0;
    int two = nums.length;

    for (int i = 0; i < two; ) {
      if (nums[i] == 1) {
        i++;
      } else if (nums[i] == 0) {
        swap(nums, zero++, i++);
      } else {
        two--;
        swap(nums, i, two);
      }
    }
  }

  private void swap(int[] nums, int i, int j) {
    int tmp = nums[i];
    nums[i] = nums[j];
    nums[j] = tmp;
  }
}
