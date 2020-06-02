package p1139;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {

    @Test
    public void largest1BorderedSquare() {
        Solution s = new Solution();
        assertEquals(9, s.largest1BorderedSquare(new int[][] {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}}));
        assertEquals(1, s.largest1BorderedSquare(new int[][] {{1, 1, 0, 0}}));
    }
}
