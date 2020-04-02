package p213;

class Solution {
  public int rob(int[] nums) {
    if (nums == null || nums.length == 0) return 0;
    if (nums.length == 1) return nums[0];
    return Math.max(rob(nums, 1, nums.length), rob(nums, 0, nums.length - 1));
  }

  int rob(int[] nums, int start, int end) {
    int preMax = 0, currMax = 0, tmp;
    for (int i = start; i < end; i++) {
      tmp = currMax;
      currMax = Math.max(preMax + nums[i], currMax);
      preMax = tmp;
    }
    return currMax;
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    int ans = s.rob(new int[] {1, 2, 3, 1});
    System.out.println(ans);
  }
}
