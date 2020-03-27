package p29;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {

    @Test
    public void divide() {
        Solution s = new Solution();
        assertEquals(1, s.divide(-2147483648, -2147483648));
        assertEquals(-2, s.divide(7, -3));

        assertEquals(3, s.divide(10, 3));
    }
}
