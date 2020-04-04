package p42;

/**
 * 接雨水
 *
 * <p>最左边和最右边的数没有雨水，然后其他的雨水量等于左边最高和右边最高的较小值减去本身 <br>
 * Math.min(max(left[i]), max(right[i])) - i
 */
class Solution {
  public int trap(int[] height) {
    int[] left = new int[height.length];
    int[] right = new int[height.length];
    int ans = 0;
    for (int i = 1; i < height.length - 1; i++) {
      left[i] = max(height, 0, i);
      right[i] = max(height, i, height.length - 1);
      ans += Math.min(left[i], right[i]) - height[i];
    }
    return ans;
  }

  private int max(int[] height, int start, int end) {
    int m = height[start];
    for (int i = start + 1; i <= end; i++) {
      if (height[i] > m) {
        m = height[i];
      }
    }
    return m;
  }
}
