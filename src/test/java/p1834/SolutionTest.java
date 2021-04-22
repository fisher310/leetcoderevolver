package p1834;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author lihailong
 * @since 2021/04/20 14:25:54
 */
public class SolutionTest {

    @Test
    public void getOrder() {
        Solution s = new Solution();

        assertArrayEquals(
                new int[] {6, 1, 2, 9, 4, 10, 0, 11, 5, 13, 3, 8, 12, 7},
                s.getOrder(
                        new int[][] {
                            {19, 13}, {16, 9}, {21, 10}, {32, 25}, {37, 4}, {49, 24}, {2, 15},
                            {38, 41}, {37, 34}, {33, 6}, {45, 4}, {18, 18}, {46, 39}, {12, 24}
                        }));

        assertArrayEquals(
                new int[] {4, 3, 2, 0, 1},
                s.getOrder(new int[][] {{7, 10}, {7, 12}, {7, 5}, {7, 4}, {7, 2}}));
        assertArrayEquals(
                new int[] {0, 2, 3, 1}, s.getOrder(new int[][] {{1, 2}, {2, 4}, {3, 2}, {4, 1}}));
    }
}
