package p454;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {

  @Test
  public void fourSumCount() {
    Solution s = new Solution();
    assertEquals(
        2,
        s.fourSumCount(new int[] {1, 2}, new int[] {-2, -1}, new int[] {-1, 2}, new int[] {0, 2}));
  }
}
