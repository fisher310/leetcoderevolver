package tmp;

import org.junit.Assert;

import java.util.Arrays;

class Solution {
  public int longestConsecutive(int[] nums) {
    if (nums == null || nums.length == 0) return 0;
    Arrays.sort(nums);
    int ans = 0;

    int l = 0;
    int r = 0;

    while (l < nums.length) {
      int pre = nums[l];
      r = l + 1;
      int count = 1;
      while (r < nums.length) {
        if (nums[r] == pre + 1) {
          count++;
          pre = nums[r];
          r++;
        } else if (nums[r] == pre) {
          r++;
        } else {
          break;
        }
      }
      ans = Math.max(ans, count);
      l = r;
    }
    return ans;
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    Assert.assertEquals(4, s.longestConsecutive(new int[] {100, 4, 200, 1, 3, 2}));
    Assert.assertEquals(3, s.longestConsecutive(new int[] {1, 2, 0, 1}));
  }
}
