package m13;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {

  @Test
  public void movingCount() {
    Solution s = new Solution();
    assertEquals(3, s.movingCount(2, 3, 1));
    assertEquals(1, s.movingCount(2, 3, 0));
  }
}
