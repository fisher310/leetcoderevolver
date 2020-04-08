package p63;

/** 不同路径2 */
class Solution {
  public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    if (null == obstacleGrid || obstacleGrid.length == 0) return 0;
    int R = obstacleGrid.length;
    int C = obstacleGrid[0].length;
    for (int i = 0; i < R; i++) {
      for (int j = 0; j < C; j++) {
        if (obstacleGrid[i][j] == 1) {
          obstacleGrid[i][j] = 0;
        } else if (i == 0) {
          obstacleGrid[i][j] = (j == 0 || obstacleGrid[i][j - 1] > 0) ? 1 : 0;
        } else if (j == 0) {
          obstacleGrid[i][j] = obstacleGrid[i - 1][j] > 0 ? 1 : 0;
        } else {
          obstacleGrid[i][j] = obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1];
        }
      }
    }

    return obstacleGrid[R - 1][C - 1];
  }
}
