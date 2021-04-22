package p1827;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author lihailong
 * @since 2021/04/21 21:24:55
 */
public class SolutionTest {

    @Test
    public void minOperations() {

        Solution s = new Solution();
        assertEquals(3, s.minOperations(new int[] {1, 1, 1}));
        assertEquals(14, s.minOperations(new int[] {1, 5, 2, 4, 1}));
        assertEquals(0, s.minOperations(new int[] {8}));
    }
}
