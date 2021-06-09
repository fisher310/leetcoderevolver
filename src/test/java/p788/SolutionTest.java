package p788;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author lihailong
 * @since 2021/06/09 10:54:09
 */
public class SolutionTest {

    @Test
    public void rotatedDigits() {

        Solution s = new Solution();
        assertEquals(1, s.rotatedDigits(2));
        assertEquals(40, s.rotatedDigits(100));
        assertEquals(4, s.rotatedDigits(10));
    }
}