package p633;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void judgeSquareSum() {
        Solution s = new Solution();
        assertFalse(s.judgeSquareSum(88888888));
        assertTrue(s.judgeSquareSum(1));
        assertTrue(s.judgeSquareSum(5));
        assertFalse(s.judgeSquareSum(3));
    }
}
