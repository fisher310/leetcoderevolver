package p209;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {

  @Test
  public void minSubArrayLen() {
    Solution s = new Solution();
    assertEquals(3, s.minSubArrayLen(11, new int[] {1, 2, 3, 4, 5}));
    assertEquals(2, s.minSubArrayLen(7, new int[] {2, 3, 1, 2, 4, 3}));
  }
}
