package p209;

/** 长度最小的子数组 */
class Solution {
  public int minSubArrayLen(int s, int[] nums) {
    if (nums == null || nums.length == 0) return 0;
    int i = 0, j = 0, ans = Integer.MAX_VALUE, sum = 0, N = nums.length;
    for (; i < N; ) {
      if (sum < s) {
        if (j < N) {
          sum += nums[j++];
        } else {
          break;
        }
      } else {
        ans = Math.min(ans, j - i);
        sum -= nums[i++];
      }
    }
    if (ans == Integer.MAX_VALUE) return 0;
    return ans;
  }
}
