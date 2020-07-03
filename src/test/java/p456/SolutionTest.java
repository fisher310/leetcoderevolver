package p456;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SolutionTest {

    @Test
    public void find132pattern() {

        Solution s = new Solution();
        assertTrue(s.find132pattern(new int[] {3, 5, 0, 3, 4}));
        assertTrue(s.find132pattern(new int[] {3, 1, 4, 2}));
        assertFalse(s.find132pattern(new int[] {1, 2, 3, 4}));
        assertTrue(s.find132pattern(new int[] {-1, 3, 2, 0}));
    }
}
