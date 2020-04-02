package p198;

class Solution {
  public int rob(int[] nums) {
    int preMax = 0, curMax = 0;
    for (int n : nums) {
      int temp = curMax;
      curMax = Math.max(n + preMax, curMax);
      preMax = temp;
    }
    return curMax;
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    int ans = s.rob(new int[] {1, 2, 3, 1});
    System.out.println(ans);
    ans = s.rob(new int[] {2, 7, 9, 3, 1});
    System.out.println(ans);
  }
}
