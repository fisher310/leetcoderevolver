package p220;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SolutionTest {

  @Test
  public void containsNearbyAlmostDuplicate() {
    Solution s = new Solution();
    assertTrue(s.containsNearbyAlmostDuplicate(new int[] {7, 1, 3}, 2, 3));
    assertFalse(s.containsNearbyAlmostDuplicate(new int[] {-1, -1}, 1, -1));
    assertTrue(s.containsNearbyAlmostDuplicate(new int[] {3, 2, 3, 1, 2, 3}, 2, 0));
    assertTrue(s.containsNearbyAlmostDuplicate(new int[] {1, 2, 3, 1}, 3, 0));
    assertTrue(s.containsNearbyAlmostDuplicate(new int[] {1, 0, 1, 1}, 1, 2));
    assertFalse(s.containsNearbyAlmostDuplicate(new int[] {1, 5, 9, 1, 5, 9}, 2, 3));
  }
}
