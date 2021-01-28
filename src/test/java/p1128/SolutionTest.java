package p1128;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author lihailong
 * @since 2021/1/26 0026
 */
public class SolutionTest {

    @Test
    public void numEquivDominoPairs() {
        Solution s = new Solution();
        assertEquals(
                4,
                s.numEquivDominoPairs(
                        new int[][] {{1, 1}, {2, 2}, {1, 1}, {1, 2}, {1, 2}, {1, 1}}));
        assertEquals(1, s.numEquivDominoPairs(new int[][] {{1, 2}, {2, 1}, {3, 4}, {5, 6}}));
    }
}
