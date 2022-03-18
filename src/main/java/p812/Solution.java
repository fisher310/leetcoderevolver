package p812;

public class Solution {

  public double largestTriangleArea(int[][] points) {

    double max = 0;
    for (int i = 0; i < points.length; i++) {
      for (int j = i + 1; j < points.length; j++) {
        for (int k = j + 1; k < points.length; k++) {
          int[] p1 = points[i];
          int[] p2 = points[j];
          int[] p3 = points[k];
          double a = dis(p1, p2);
          double b = dis(p2, p3);
          double c = dis(p1, p3);

          // 1/4sqrt[(a+b+c)(a+b-c)(a+c-b)(b+c-a)]
          if (isTriangle(a, b, c)) {

            double s = (a + b + c) * (a + b - c) * (a + c - b) * (b + c - a);
            max = Math.max(max, s);
          }
        }
      }
    }
    return Math.sqrt(max) / 4.0;
  }

  double dis(int[] p1, int[] p2) {
    return Math.sqrt((p1[0] - p2[0]) * (p1[0] - p2[0]) + (p1[1] - p2[1]) * (p1[1] - p2[1]));
  }

  boolean isTriangle(double a, double b, double c) {
    return (a + b) > c && (b + c) > a && (a + c) > b;
  }

  public static void main(String[] args) {

    // 54.74486277268398, 30.4138126514911,24.331050121192877,= NaN
    double a = 54.74486277268398;
    double b = 30.4138126514911;
    double c = 24.331050121192877;
    System.out.println((a + b + c) * (a + b - c) * (b + c - a) * (a + c - b));

    Solution s = new Solution();
    //    System.out.println(s.largestTriangleArea(new int[][] {{0, 0}, {0, 1}, {1, 0}, {0, 2}, {2,
    // 0}}));
    System.out.println(
        s.largestTriangleArea(
            new int[][] {
              {-35, 19}, {40, 19}, {27, -20}, {35, -3}, {44, 20}, {22, -21}, {35, 33}, {-19, 42},
              {11, 47}, {11, 37}
            }));
  }
}
