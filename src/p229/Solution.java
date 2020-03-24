package p229;

import java.util.ArrayList;
import java.util.List;

class Solution {
  public List<Integer> majorityElement(int[] nums) {
    if (nums == null || nums.length == 0) {
      return new ArrayList<>();
    }
    Integer major1 = null, major2 = null, count1 = 0, count2 = 0;

    for (int c : nums) {
      if (major1 != null && major1 == c) {
        count1++;
      } else if (major2 != null && major2 == c) {
        count2++;
      } else if (count1 == 0) {
        major1 = c;
        count1++;
      } else if (count2 == 0) {
        major2 = c;
        count2++;
      } else {
        count1--;
        count2--;
      }
    }

    List<Integer> ans = new ArrayList<>(2);
    int c1 = 0, c2 = 0;
    for (int c : nums) {
      if (major1 != null && c == major1) c1++;
      if (major2 != null && c == major2) c2++;
    }
    if (c1 > nums.length / 3) ans.add(major1);
    if (c2 > nums.length / 3) ans.add(major2);
    return ans;
  }
}
