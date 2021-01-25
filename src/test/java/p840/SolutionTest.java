package p840;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author lihailong
 * @since 2021/1/14 0014
 */
public class SolutionTest {

    @Test
    public void numMagicSquaresInside() {
        Solution s = new Solution();

        assertEquals(
                1, s.numMagicSquaresInside(new int[][] {{4, 3, 8, 4}, {9, 5, 1, 9}, {2, 7, 6, 2}}));
    }
}
