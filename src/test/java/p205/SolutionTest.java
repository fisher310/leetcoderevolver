package p205;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SolutionTest {

  @Test
  public void isIsomorphic() {
    Solution s = new Solution();
    assertTrue(s.isIsomorphic("egg", "add"));
    assertFalse(s.isIsomorphic("foo", "bar"));
    assertTrue(s.isIsomorphic("ab", "ca"));
    assertFalse(s.isIsomorphic("ab", "aa"));
    assertFalse(s.isIsomorphic("bar", "foo"));
  }
}
