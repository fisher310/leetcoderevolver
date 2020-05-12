package p91;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

  @Test
  public void numDecodings() {
    Solution s = new Solution();
    assertEquals(0, s.numDecodings("01"));
    assertEquals(1, s.numDecodings("10"));
    assertEquals(2, s.numDecodings("12"));
    assertEquals(3, s.numDecodings("226"));
    assertEquals(0, s.numDecodings("0"));
    assertEquals(0, s.numDecodings("2260"));
    assertEquals(0, s.numDecodings("100"));
    assertEquals(1, s.numDecodings("101"));
  }
}
