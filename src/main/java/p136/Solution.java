package p136;

import java.util.HashMap;
import java.util.Map;

/** 只出现一次的数字 */
class Solution {
  public int singleNumber(int[] nums) {
    Map<Integer, Integer> count = new HashMap<>();
    for (int n : nums) {
      count.put(n, count.getOrDefault(n, 0) + 1);
    }

    for (Map.Entry<Integer, Integer> e : count.entrySet()) {
      if (e.getValue() == 1) return e.getKey();
    }
    return 0;
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    int ans = solution.singleNumber(new int[] {2, 2, 1});
    System.out.println(ans);
  }
}
