package week285.p1;

import java.util.HashSet;
import java.util.Set;

public class Solution {
  public int countHillValley(int[] nums) {

    int ans = 0;
    Set<String> set = new HashSet<>();
    for (int i = 1; i < nums.length - 1; i++) {
      int j = i - 1;
      while (j > 0 && nums[j] == nums[i]) {
        j--;
      }
      int k = i + 1;
      while (k < nums.length-1 && nums[k] == nums[i]) {
        k++;
      }
      if (((nums[i] > nums[j] && nums[i] > nums[k]) || (nums[i] < nums[j] && nums[i] < nums[k]))
          && !set.contains(j + "_" + k)) {
        ans++;
        set.add(j + "_" + k);
      }
    }

    return ans;
  }
}
