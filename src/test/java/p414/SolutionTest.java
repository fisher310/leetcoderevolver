package p414;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

  @Test
  public void thirdMax() {
    Solution s = new Solution();
    assertEquals(1, s.thirdMax(new int[] {-2147483648, 1, 1}));
    assertEquals(1, s.thirdMax(new int[] {3, 2, 1}));
    assertEquals(2, s.thirdMax(new int[] {1, 2}));
    assertEquals(1, s.thirdMax(new int[] {2, 2, 3, 1}));
  }
}
