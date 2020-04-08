package p64;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {

  @Test
  public void minPathSum() {
    Solution s = new Solution();
    int[][] grid = new int[][] {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
    assertEquals(7, s.minPathSum(grid));

    grid = new int[][] {{1, 2}};
    assertEquals(3, s.minPathSum(grid));

    grid = new int[][] {{1}, {3}};
    assertEquals(4, s.minPathSum(grid));
  }
}
