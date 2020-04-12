package p219;

import java.util.HashMap;
import java.util.Map;

/** 存在重复元素 II */
class Solution {
  public boolean containsNearbyDuplicate(int[] nums, int k) {
    if (nums == null || nums.length == 0) return false;
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      if (map.containsKey(nums[i])) {
        int pre = map.get(nums[i]);
        if (Math.abs(i - pre) <= k) {
          return true;
        }
      }
      map.put(nums[i], i);
    }

    return false;
  }
}
