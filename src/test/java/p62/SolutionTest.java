package p62;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {

  @Test
  public void uniquePaths() {
    Solution s = new Solution();
    assertEquals(3, s.uniquePaths(3, 2));
    assertEquals(28, s.uniquePaths(7, 3));
  }
}
