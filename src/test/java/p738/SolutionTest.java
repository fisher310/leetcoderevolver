package p738;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author lihailong
 * @since 2020/12/16 0016
 */
public class SolutionTest {

    @Test
    public void monotoneIncreasingDigits() {
        Solution s = new Solution();
        assertEquals(299, s.monotoneIncreasingDigits(332));
        assertEquals(1234, s.monotoneIncreasingDigits(1234));
    }
}