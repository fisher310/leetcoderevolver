package p132;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author lihailong
 * @since 2021/04/09 14:40:43
 */
public class SolutionTest {

    @Test
    public void minCut() {
        Solution s = new Solution();
        assertEquals(1, s.minCut("aab"));
        assertEquals(0, s.minCut("aaa"));
        assertEquals(1, s.minCut("ab"));
    }
}