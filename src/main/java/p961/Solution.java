package p961;

import java.util.HashSet;
import java.util.Set;
import org.junit.Assert;

public class Solution {

  public int repeatedNTimes(int[] nums) {

    Set<Integer> set = new HashSet<>();

    for (int n : nums) {
      if (set.contains(n)) {
        return n;
      }
      set.add(n);
    }

    return -1;
  }

  public static void main(String[] args) {

    Solution s = new Solution();
    Assert.assertEquals(3, s.repeatedNTimes(new int[] {1, 2, 3, 3}));
  }
}
