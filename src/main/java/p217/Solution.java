package p217;

import java.util.HashSet;
import java.util.Set;

/** 存在重复元素 */
class Solution {
  public boolean containsDuplicate(int[] nums) {
    if (null == nums || nums.length == 0) return false;

    Set<Integer> set = new HashSet<>();
    for (int n : nums) {
      if (set.contains(n)) return true;
      set.add(n);
    }
    return false;
  }
}
