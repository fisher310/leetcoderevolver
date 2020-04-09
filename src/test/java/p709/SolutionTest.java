package p709;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {

  @Test
  public void toLowerCase() {
    Solution s = new Solution();
    assertEquals("hello", s.toLowerCase("HELLO"));
    assertEquals("hello", s.toLowerCase("hello"));
    assertEquals("lovely", s.toLowerCase("LOVELY"));
  }
}
