package p851;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * @author lihailong
 * @since 2021/1/4 0004
 */
public class SolutionTest {

    @Test
    public void loudAndRich() {

        Solution s = new Solution();
        assertArrayEquals(
                new int[] {5, 5, 2, 5, 4, 5, 6, 7},
                s.loudAndRich(
                        new int[][] {{1, 0}, {2, 1}, {3, 1}, {3, 7}, {4, 3}, {5, 3}, {6, 3}},
                        new int[] {3, 2, 5, 4, 6, 1, 7, 0}));
    }
}
