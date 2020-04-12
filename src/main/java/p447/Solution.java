package p447;

import java.util.HashMap;
import java.util.Map;

/** 回旋镖的数量 */
class Solution {
  public int numberOfBoomerangs(int[][] points) {
    if (null == points || points.length == 0) return 0;

    Map<Integer, Integer> map = new HashMap<>();
    int ans = 0;
    for (int i = 0; i < points.length; i++) {
      map.clear();
      for (int j = 0; j < points.length; j++) {
        if (i != j) {
          int d = dis(points[i], points[j]);
          map.put(d, map.getOrDefault(d, 0) + 1);
        }
      }
      for (Map.Entry<Integer, Integer> e : map.entrySet()) {
        if (e.getValue() > 1) {
          ans += e.getValue() * (e.getValue() - 1);
        }
      }
    }

    return ans;
  }

  private int dis(int[] i, int[] j) {
    int x = i[0] - j[0];
    int y = i[1] - j[1];
    return x * x + y * y;
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    int ans = s.numberOfBoomerangs(new int[][] {{0, 0}, {1, 0}, {2, 0}});
    System.out.println(ans);
  }
}
