package p42;

/**
 * 接雨水
 *
 * <p>最左边和最右边的数没有雨水，然后其他的雨水量等于左边最高和右边最高的较小值减去本身 <br>
 * Math.min(max(left[i]), max(right[i])) - i
 */
class Solution {
  public int trap(int[] height) {
    if (null == height || height.length == 0) return 0;
    int len = height.length;
    int[] left = new int[len];
    int[] right = new int[len];
    left[0] = height[0];
    right[len - 1] = height[len - 1];
    for (int i = 1, n = len; i < n; i++) {
      left[i] = Math.max(height[i], left[i - 1]);
      right[n - 1 - i] = Math.max(height[n - 1 - i], right[n - i]);
    }

    int ans = 0;
    for (int i = 1; i < len - 1; i++) {
      ans += Math.min(left[i], right[i]) - height[i];
    }
    return ans;
  }
}
