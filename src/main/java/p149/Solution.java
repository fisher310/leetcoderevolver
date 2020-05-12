package p149;

import java.util.*;

/** 直线上最多的点数 */
class Solution {
  public int maxPoints(int[][] points) {

    if (null == points || points.length == 0) return 0;
    if (points.length == 1) return 1;

    Map<String, Set<Point>> map = new HashMap<>();

    for (int i = 0; i < points.length; i++) {
      for (int j = i + 1; j < points.length; j++) {
        String gradient = gradient(points[i], points[j]);
        Set<Point> set = map.getOrDefault(gradient, new HashSet<>());
        set.add(new Point(points[i][0], points[i][1], i));
        set.add(new Point(points[j][0], points[j][1], j));
        map.put(gradient, set);
      }
    }

    int ans = 0;
    for (Map.Entry<String, Set<Point>> e : map.entrySet()) {
      ans = Math.max(ans, e.getValue().size());
    }
    return ans;
  }

  private static class Point {
    int x;
    int y;
    int p;

    Point(int _x, int _y, int _p) {
      this.x = _x;
      this.y = _y;
      this.p = _p;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      Point point = (Point) o;
      return x == point.x && y == point.y && p == point.p;
    }

    @Override
    public int hashCode() {
      return Objects.hash(x, y, p);
    }
  }

  String gradient(int[] p1, int[] p2) {
    double value = ((double) (p2[1] - p1[1])) / (p2[0] - p1[0]);
    if (Double.isInfinite(value)) {
      return "Inf_" + p1[0];
    }
    double b = p2[1] - value * p2[0];
    return String.valueOf(value) + "_" + b;
  }
}
