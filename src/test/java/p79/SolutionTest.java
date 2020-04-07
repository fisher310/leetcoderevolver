package p79;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SolutionTest {

  @Test
  public void exist() {
    Solution s = new Solution();
    char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
    assertTrue(s.exist(board, "ABCCED"));

    assertTrue(s.exist(board, "SEE"));

    assertFalse(s.exist(board, "ABCB"));
  }
}
