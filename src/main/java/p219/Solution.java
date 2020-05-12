package p219;

import java.util.HashSet;
import java.util.Set;

/** 存在重复元素 II */
class Solution {
  public boolean containsNearbyDuplicate(int[] nums, int k) {
    if (nums == null || nums.length == 0) return false;
    Set<Integer> set = new HashSet<>();
    for (int i = 0; i < nums.length; i++) {
      if (set.contains(nums[i])) {
        return true;
      }
      set.add(nums[i]);
      if (set.size() == k + 1) {
        set.remove(nums[i - k]);
      }
    }

    return false;
  }
}
