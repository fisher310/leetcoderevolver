package p137;

import java.util.*;
import org.junit.Assert;

public class Solution {
  public int singleNumber(int[] nums) {
    Map<Integer, Integer> map = new HashMap<>();

    for (int i = 0; i < nums.length; i++) {
      int v = map.getOrDefault(nums[i], 0) + 1;
      map.put(nums[i], v);
    }

    for (Map.Entry<Integer, Integer> e : map.entrySet()) {
      if (e.getValue() == 2) {
        return e.getKey();
      }
    }

    return -1;
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    Assert.assertEquals("test01", 3, s.singleNumber(new int[] {2, 2, 3, 2}));
  }
}
