package p220;

import java.util.TreeSet;

/** 存在重复元素 III */
public class Solution {

  public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
    if (nums == null || nums.length == 0) return false;
    if (t < 0) return false;

    TreeSet<Long> treeSet = new TreeSet<>();

    for (int i = 0; i < nums.length; i++) {

      Long ceiling = treeSet.ceiling((long) nums[i] - t);
      if (ceiling != null && ceiling <= (long) nums[i] + t) {
        return true;
      }

      treeSet.add((long) nums[i]);

      if (treeSet.size() == k + 1) {
        treeSet.remove((long) nums[i - k]);
      }
    }
    return false;
  }
}
