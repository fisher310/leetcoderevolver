package p151;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {

  @Test
  public void reverseWords() {
    Solution s = new Solution();
    assertEquals("blue is sky the", s.reverseWords("the sky is blue"));
    assertEquals("world! hello", s.reverseWords("  hello world!  "));
    assertEquals("example good a", s.reverseWords("a good   example"));
  }
}
