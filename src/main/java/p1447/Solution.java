package p1447;

import java.util.*;

/**
 * @author lihailong
 * @since 2022-02-10 18:36:22
 */
class Solution {
  public List<String> simplifiedFractions(int n) {
    if (n == 0 || n == 1) {
      return Collections.emptyList();
    }

    boolean[][] matrix = new boolean[n + 1][n + 1];
    List<String> ans = new ArrayList<>();
    for (int i = 1; i < n; i++) {
      for (int j = i + 1; j <= n; j++) {
        int a = i, b = j;
        int g = gcd(a, b);
        if (g != 1) {
          a /= g;
          b /= g;
        }
        if (!matrix[a][b]) {
          ans.add(a + "/" + b);
          matrix[a][b] = true;
        }
      }
    }

    return ans;
  }

  int gcd(int m, int n) {
    while (m != 0) {

      if (m < n) {
        int tmp = m;
        m = n;
        n = tmp;
      }
      m = m % n;
    }
    return n;
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println(s.simplifiedFractions(5));
    List<String> ans = s.simplifiedFractions(4);
    System.out.println(ans);
    ans = s.simplifiedFractions(3);
    System.out.println(ans);
    ans = s.simplifiedFractions(1);
    System.out.println(ans);
    ans = s.simplifiedFractions(2);
    System.out.println(ans);
    System.out.println(s.simplifiedFractions(100));

  }
}
