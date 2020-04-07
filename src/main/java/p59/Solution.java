package p59;

import util.ArrayUtils;

/** 螺旋矩阵 二 */
public class Solution {
  public int[][] generateMatrix(int n) {
    if (n == 0) return new int[0][0];
    int N = n * n;

    int[][] matrix = new int[n][n];
    int[] dx = {0, 1, 0, -1};
    int[] dy = {1, 0, -1, 0};
    int r = 0, c = 0, di = 0;
    for (int i = 1; i <= N; i++) {
      matrix[r][c] = i;
      int cr = r + dx[di];
      int cc = c + dy[di];
      if (0 <= cr && cr < n && 0 <= cc && cc < n && matrix[cr][cc] == 0) {
        r = cr;
        c = cc;
      } else {
        di = (di + 1) % 4;
        r = r + dx[di];
        c = c + dy[di];
      }
    }
    return matrix;
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    int[][] matrix = s.generateMatrix(4);
    ArrayUtils.print(matrix);
  }
}
