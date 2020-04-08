package p80;

import java.util.Arrays;

/** 删除排序数组中的重复项2 */
class Solution {
  public int removeDuplicates(int[] nums) {
    if (null == nums || nums.length == 0) return 0;

    int N = nums.length;
    int k = 1;
    int c = 1;
    for (int i = 1; i < N; i++) {
      if (nums[i] == nums[i - 1]) {
        c++;
      } else {
        c = 1;
      }

      if (c <= 2) {
        nums[k++] = nums[i];
      }
    }
    return k;
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    int[] input = new int[] {1, 1, 1, 2, 2, 3};
    int ans = s.removeDuplicates(input);
    System.out.println(ans);
    System.out.println(Arrays.toString(input));

    int[] input2 = new int[] {0, 0, 1, 1, 1, 1, 2, 3, 3};
    int ans2 = s.removeDuplicates(input2);
    System.out.println(ans2);
    System.out.println(Arrays.toString(input2));

    int[] input3 = new int[] {1, 2, 3, 4, 5};
    int ans3 = s.removeDuplicates(input3);
    System.out.println(ans3);
    System.out.println(Arrays.toString(input3));
  }
}
