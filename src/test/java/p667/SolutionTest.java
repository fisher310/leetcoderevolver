package p667;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * @author lihailong
 * @since 2021/1/12 0012
 */
public class SolutionTest {

    @Test
    public void constructArray() {
        Solution s = new Solution();

        assertArrayEquals(new int[] {1, 3, 2}, s.constructArray(3, 2));
        assertArrayEquals(new int[] {1, 2, 3}, s.constructArray(3, 1));
    }
}
