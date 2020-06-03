package p207;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class SolutionTest {

    @Test
    public void canFinish() {
        Solution s = new Solution();
        //        assertTrue(s.canFinish(2, new int[][] {{1, 0}}));
        //
        //        assertFalse(s.canFinish(2, new int[][] {{1, 0}, {0, 1}}));
//        assertTrue( s.canFinish(1, new int[][]{}));
        assertTrue(s.canFinish(3, new int[][]{{1,0}}));
        assertTrue(
                s.canFinish(
                        8,
                        new int[][] {
                            {2, 0}, {4, 2}, {6, 4}, {7, 6}, {3, 1}, {5, 1}, {5, 3}, {7, 5}, {4, 3}
                        }));
    }
}
