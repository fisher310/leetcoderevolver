package p125;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SolutionTest {

  @Test
  public void isPalindrome() {
    Solution s = new Solution();
    assertTrue(s.isPalindrome("A man, a plan, a canal: Panama"));

    assertFalse(s.isPalindrome("race a car"));
  }
}
