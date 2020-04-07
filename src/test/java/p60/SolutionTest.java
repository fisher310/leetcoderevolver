package p60;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {

  @Test
  public void getPermutation() {
    Solution s = new Solution();
    long start = System.currentTimeMillis();
    System.out.println(s.getPermutation(9, 24479));
    long duration = System.currentTimeMillis() - start;
    System.out.println("time: " + duration);
    assertEquals("213", s.getPermutation(3, 3));
    assertEquals("2314", s.getPermutation(4, 9));
  }
}
