package p219;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

  @Test
  public void containsNearbyDuplicate() {
    Solution s = new Solution();
    assertTrue(s.containsNearbyDuplicate(new int[] {1, 2, 3, 1}, 3));
    assertTrue(s.containsNearbyDuplicate(new int[] {1, 0, 1, 1}, 1));
    assertFalse(s.containsNearbyDuplicate(new int[] {1, 2, 3, 1, 2, 3}, 2));
  }
}
