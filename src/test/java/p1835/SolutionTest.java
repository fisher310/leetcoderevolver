package p1835;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author lihailong
 * @since 2021/04/21 21:09:24
 */
public class SolutionTest {

    @Test
    public void getXORSum() {
        Solution s = new Solution();

        assertEquals(0, s.getXORSum(new int[] {1, 2, 3}, new int[] {6, 5}));
        assertEquals(4, s.getXORSum(new int[] {12}, new int[] {4}));
    }
}
