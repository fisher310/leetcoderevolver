package p69;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {

    @Test
    public void mySqrt() {
        Solution s = new Solution();
        assertEquals( 46340, s.mySqrt(2147395600));
        assertEquals(2, s.mySqrt(4));
        assertEquals(1, s.mySqrt(1));
        assertEquals(1, s.mySqrt(2));
        assertEquals(2, s.mySqrt(8));
    }
}
