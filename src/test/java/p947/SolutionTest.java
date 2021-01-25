package p947;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author lihailong
 * @since 2021/1/15 0015
 */
public class SolutionTest {

    @Test
    public void removeStones() {

        Solution s = new Solution();
        assertEquals(
                5, s.removeStones(new int[][] {{0, 0}, {0, 1}, {1, 0}, {1, 2}, {2, 1}, {2, 2}}));
    }
}
