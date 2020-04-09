package p75;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class SolutionTest {

  @Test
  public void sortColors() {
    Solution s = new Solution();
    int[] nums = new int[] {2, 0, 2, 1, 1, 0};
    s.sortColors(nums);
    assertArrayEquals(new int[] {0, 0, 1, 1, 2, 2}, nums);
  }
}
