package p1006;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author lihailong
 * @since 2021-04-01 21:49:18
 */
public class SolutionTest {

    @Test
    public void clumsy() {
        Solution s = new Solution();
        assertEquals(12, s.clumsy(10));
        assertEquals(7, s.clumsy(4));
    }
}