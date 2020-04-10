package p345;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {

  @Test
  public void reverseVowels() {
    Solution s = new Solution();
    assertEquals("holle", s.reverseVowels("hello"));
    assertEquals("leotcede", s.reverseVowels("leetcode"));
    assertEquals("Aa", s.reverseVowels("aA"));
  }
}
