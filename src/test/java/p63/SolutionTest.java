package p63;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {

  @Test
  public void uniquePathsWithObstacles() {
    Solution s = new Solution();
    int[][] obstacleGrid = new int[][] {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
    assertEquals(2, s.uniquePathsWithObstacles(obstacleGrid));

    obstacleGrid = new int[][] {{1, 0}};
    assertEquals(0, s.uniquePathsWithObstacles(obstacleGrid));
  }
}
