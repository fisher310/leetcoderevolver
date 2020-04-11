package p454;

import java.util.HashMap;
import java.util.Map;

/** 四数相加 II */
class Solution {
  public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
    Map<Integer, Integer> cd = new HashMap<>();
    for (int c : C) {
      for (int d : D) {
        cd.put(c + d, cd.getOrDefault(c + d, 0) + 1);
      }
    }

    int ans = 0;
    for (int a : A) {
      for (int b : B) {
        if (cd.containsKey(-a - b)) {
          ans += cd.get(-a - b);
        }
      }
    }

    return ans;
  }
}
