package week283.p02;

import org.apache.commons.math3.stat.descriptive.summary.Sum;
import org.junit.Assert;

import java.util.Arrays;

/**
 * @author lihailong
 * @since 2022-03-06 10:26:37
 */
class Solution {
  public long minimalKSum(int[] nums, int k) {

    Arrays.sort(nums);

    long ans = 0;
    int min = 0;
    int added = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] - min - 1 > 0) {
        if (added + nums[i] - min - 1 >= k) {
          // ok
          ans += sum(min + 1, min + (k - added));
          return ans;
        }
        added += nums[i] - min - 1;
        ans += sum(min + 1, nums[i] - 1);
      }
      min = nums[i];
    }

    // steel not ok
    min = nums[nums.length - 1];
    ans += sum(min + 1, min + (k - added));
    return ans;
  }

  long sum(long a, long b) {
    return (b - a + 1) * (a + b) / 2;
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    Assert.assertEquals(25, s.minimalKSum(new int[] {5, 6}, 6));
    Assert.assertEquals(5, s.minimalKSum(new int[] {1, 4, 25, 10, 25}, 2));
  }
}
