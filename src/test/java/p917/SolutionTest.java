package p917;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {

  @Test
  public void reverseOnlyLetters() {
    Solution s = new Solution();
    assertEquals("dc-ba", s.reverseOnlyLetters("ab-cd"));
    assertEquals("j-Ih-gfE-dCba", s.reverseOnlyLetters("a-bC-dEf-ghIj"));
    assertEquals("Qedo1ct-eeLg=ntse-T!", s.reverseOnlyLetters("Test1ng-Leet=code-Q!"));
  }
}
