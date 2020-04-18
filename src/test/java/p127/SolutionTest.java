package p127;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class SolutionTest {

  @Test
  public void ladderLength() {
    Solution s = new Solution();
    assertEquals(
        5, s.ladderLength("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log", "cog")));
    assertEquals(0, s.ladderLength("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log")));
  }
}
