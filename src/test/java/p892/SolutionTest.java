package p892;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {

    @Test
    public void surfaceArea() {

        Solution s = new Solution();

        assertEquals(10, s.surfaceArea(new int[][]{{2}}));
        assertEquals(
                34,
                s.surfaceArea(
                        new int[][]{
                                {
                                        1, 2,
                                },
                                {3, 4}
                        }));
        assertEquals(16, s.surfaceArea(new int[][]{{1, 0}, {0, 2}}));
        assertEquals(32, s.surfaceArea(new int[][]{{1, 1, 1}, {1, 0, 1}, {1, 1, 1}}));
        assertEquals(46, s.surfaceArea(new int[][]{{2, 2, 2}, {2, 1, 2}, {2, 2, 2}}));
    }
}
