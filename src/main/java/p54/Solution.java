package p54;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/** 螺旋矩阵 */
class Solution {
  public List<Integer> spiralOrder(int[][] matrix) {
    if (matrix == null || matrix.length == 0) return Collections.emptyList();
    List<Integer> ans = new LinkedList<>();
    int row = matrix.length;
    int col = matrix[0].length;
    int[] x = {0, 1, 0, -1};
    int[] y = {1, 0, -1, 0};
    boolean[][] visited = new boolean[row][col];
    int r = 0, c = 0, di = 0;
    for (int i = 0; i < row * col; i++) {
      ans.add(matrix[r][c]);
      visited[r][c] = true;
      int cr = r + x[di];
      int cc = c + y[di];
      if (0 <= cr && cr < row && 0 <= cc && cc < col && !visited[cr][cc]) {
        r = cr;
        c = cc;
      } else {
        di = (di + 1) % 4;
        r = r + x[di];
        c = c + y[di];
      }
    }

    return ans;
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    int[][] matrix = new int[][] {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
    List<Integer> ans = s.spiralOrder(matrix);
    System.out.println(ans);
  }
}
