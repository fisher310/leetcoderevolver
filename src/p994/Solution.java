package p994;

public class Solution {

  public int orangesRotting(int[][] grid) {
    int[][] orientation = new int[][] {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    boolean hasBad = false;
    int count = -1;

    do {
      hasBad = false;
      for (int i = 0; i < grid.length; i++) {
        for (int j = 0; j < grid[i].length; j++) {
          if (grid[i][j] == 2) {
            for (int[] o : orientation) {
              int m = Math.min(Math.max(i + o[0], 0), grid.length - 1);
              int n = Math.min(Math.max(j + o[1], 0), grid[i].length - 1);
              if (grid[m][n] == 0) {
                grid[m][n] = 2;
                hasBad = true;
              }
            }
          }
        }
      }
      if (hasBad) {
        count++;
      }
    } while (hasBad);

    return count;
  }
}
