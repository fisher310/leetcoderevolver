package p685;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;

public class SolutionTest {

  @Test
  public void findRedundantDirectedConnection() {
    Solution s = new Solution();
    int[] ans = s.findRedundantDirectedConnection(new int[][] {{1, 2}, {1, 3}, {2, 3}});
    System.out.println(Arrays.toString(ans));
    assertArrayEquals(new int[] {2, 3}, ans);

    ans = s.findRedundantDirectedConnection(new int[][] {{1, 2}, {2, 3}, {3, 4}, {4, 1}, {1, 5}});
    System.out.println(Arrays.toString(ans));
    assertArrayEquals(new int[] {4, 1}, ans);

    ans = s.findRedundantDirectedConnection(new int[][] {{3, 4}, {4, 1}, {1, 2}, {2, 3}, {5, 1}});
    System.out.println(Arrays.toString(ans));
    assertArrayEquals(new int[] {4, 1}, ans);
  }
}
