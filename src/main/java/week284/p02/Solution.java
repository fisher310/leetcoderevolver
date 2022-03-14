package week284.p02;

/**
 * @author lihailong
 * @since 2022-03-13 10:47:48
 */
public class Solution {

  public int digArtifacts(int n, int[][] artifacts, int[][] dig) {
    int[][] grid = new int[n][n];

    for (int i = 0; i < dig.length; i++) {
      int[] point = dig[i];
      grid[point[0]][point[1]] = 1;
    }
    int ans = 0;
    outer:
    for (int[] a : artifacts) {
      int x1 = a[0];
      int y1 = a[1];
      int x2 = a[2];
      int y2 = a[3];
      for (int x = x1; x <= x2; x++) {
        for (int y = y1; y <= y2; y++) {
          if (grid[x][y] == 0) {
            continue outer;
          }
        }
      }
      ans++;
    }

    return ans;
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println(
        s.digArtifacts(2, new int[][] {{0, 0, 0, 0}, {0, 1, 1, 1}}, new int[][] {{0, 0}, {0, 1}}));
  }
}
