package p149;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

  @Test
  public void maxPoints() {
    Solution s = new Solution();
    assertEquals(
        6,
        s.maxPoints(
            new int[][] {
              {0, -12}, {5, 2}, {2, 5}, {0, -5}, {1, 5}, {2, -2}, {5, -4}, {3, 4}, {-2, 4}, {-1, 4},
              {0, -5}, {0, -8}, {-2, -1}, {0, -11}, {0, -9}
            }));
    assertEquals(3, s.maxPoints(new int[][] {{1, 1}, {2, 1}, {2, 2}, {1, 4}, {3, 3}}));
    assertEquals(3, s.maxPoints(new int[][] {{1, 1}, {2, 2}, {3, 3}}));
    assertEquals(4, s.maxPoints(new int[][] {{1, 1}, {3, 2}, {5, 3}, {4, 1}, {2, 3}, {1, 4}}));
    assertEquals(2, s.maxPoints(new int[][] {{0, 0}, {0, 0}}));
  }
}
