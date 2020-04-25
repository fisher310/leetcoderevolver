package p980;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {

    @Test
    public void uniquePathsIII() {

        Solution s = new Solution();
        int[][] grid1 = new int[][] {{1, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 2, -1}};
        assertEquals(2, s.uniquePathsIII(grid1));
    }
}
