package p64;

/** 最小路径和 */
class Solution {
  public int minPathSum(int[][] grid) {
    if (null == grid || grid.length == 0 || grid[0].length == 0) return 0;

    int R = grid.length;
    int C = grid[0].length;
    if (R == 1 && C == 1) return grid[0][0];
    for (int i = 0; i < R; i++) {
      for (int j = 0; j < C; j++) {
        if (i == 0) {
          if (j > 0) {
            grid[i][j] += grid[i][j - 1];
          }
        } else if (j == 0) {
          grid[i][j] += grid[i - 1][j];
        } else {
          grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
        }
      }
    }

    return grid[R - 1][C - 1];
  }
}
