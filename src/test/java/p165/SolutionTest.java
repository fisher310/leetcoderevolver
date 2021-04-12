package p165;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author lihailong
 * @since 2021/04/12 13:51:07
 */
public class SolutionTest {

    @Test
    public void compareVersion() {

        Solution s = new Solution();
        assertEquals(0, s.compareVersion("1.01", "1.001"));
        assertEquals(0, s.compareVersion("1.0", "1.0.0"));
        assertEquals(-1, s.compareVersion("0.1", "1.0"));
        assertEquals(1, s.compareVersion("1.0.1", "1"));
        assertEquals(-1, s.compareVersion("7.5.2.4", "7.5.3"));
        assertEquals(-1, s.compareVersion("1.1", "1.10"));

    }
}