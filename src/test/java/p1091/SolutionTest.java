package p1091;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author lihailong
 * @since 2020/12/16 0016
 */
public class SolutionTest {

    @Test
    public void shortestPathBinaryMatrix() {
        Solution s = new Solution();
        assertEquals(
                8,
                s.shortestPathBinaryMatrix(
                        new int[][] {
                            {0, 0, 1, 1, 0, 0},
                            {0, 0, 0, 0, 1, 1},
                            {1, 0, 1, 1, 0, 0},
                            {0, 0, 1, 1, 0, 0},
                            {0, 0, 0, 0, 0, 0},
                            {0, 0, 1, 0, 0, 0}
                        }));
        assertEquals(4, s.shortestPathBinaryMatrix(new int[][] {{0, 0, 0}, {1, 1, 0}, {1, 1, 0}}));
        assertEquals(2, s.shortestPathBinaryMatrix(new int[][] {{0, 1}, {1, 0}}));
    }
}
