package p665;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SolutionTest {

    @Test
    public void checkPossibility() {
        Solution s = new Solution();
        assertTrue(s.checkPossibility(new int[] {5, 7, 1, 8}));
        assertTrue(s.checkPossibility(new int[] {4, 2, 3}));
        assertFalse(s.checkPossibility(new int[] {4, 2, 1}));
    }
}
