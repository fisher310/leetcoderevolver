package p1828;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author lihailong
 * @since 2021/04/21 21:36:19
 */
public class SolutionTest {

    @Test
    public void countPoints() {

        Solution s = new Solution();
        assertArrayEquals(
                new int[] {3, 2, 2},
                s.countPoints(
                        new int[][] {{1, 3}, {3, 3}, {5, 3}, {2, 2}},
                        new int[][] {{2, 3, 1}, {4, 3, 1}, {1, 1, 2}}));
    }
}
