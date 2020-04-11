package p18;

import java.util.*;

/** 四数之和 */
class Solution {
  public List<List<Integer>> fourSum(int[] nums, int target) {
    if (nums == null || nums.length == 0) return Collections.emptyList();

    Arrays.sort(nums);

    int N = nums.length;

    Set<List<Integer>> ans = new LinkedHashSet<>();
    for (int i = 0; i < N - 3; i++) {
      for (int j = i + 1; j < N - 2; j++) {
        int l = j + 1, r = N - 1;
        while (l < r) {
          int sum = nums[i] + nums[j] + nums[l] + nums[r];
          if (sum == target) {
            ans.add(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));
            l++;
          } else if (sum < target) {
            l++;
          } else {
            r--;
          }
        }
      }
    }
    return new ArrayList<>(ans);
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println(s.fourSum(new int[] {0, 0, 0, 0}, 0));

    List<List<Integer>> lists = s.fourSum(new int[] {1, 0, -1, 0, -2, 2}, 0);
    System.out.println(lists);
  }
}
