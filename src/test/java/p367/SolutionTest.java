package p367;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SolutionTest {

    @Test
    public void isPerfectSquare() {
        Solution s = new Solution();
        assertTrue(s.isPerfectSquare(16));
        assertFalse(s.isPerfectSquare(14));
    }
}
