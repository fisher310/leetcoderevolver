package week283.p01;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lihailong
 * @since 2022-03-06 10:26:28
 */
class Solution {

  public List<String> cellsInRange(String s) {

    char c1 = s.charAt(0);
    char c2 = s.charAt(3);

    int r1 = s.charAt(1) - '0';
    int r2 = s.charAt(4) - '0';

    List<String> res = new ArrayList<>();

    for (char c = c1; c <= c2; c++) {
      for (int r = r1; r <= r2; r++) {
        res.add(String.valueOf(c) + r);
      }
    }

    return res;
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    List<String> res = s.cellsInRange("A1:F1");
    System.out.println(res);
    System.out.println(s.cellsInRange("K1:L2"));
  }
}
