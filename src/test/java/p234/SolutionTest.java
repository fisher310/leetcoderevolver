package p234;

import org.junit.Test;
import util.ListNodeUtil;

import static org.junit.Assert.assertTrue;

public class SolutionTest {

  @Test
  public void isPalindrome() {
    Solution s = new Solution();
    assertTrue(s.isPalindrome(ListNodeUtil.create(new int[] {-129, -129})));
  }
}
