package p81;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SolutionTest {

    @Test
    public void search() {
        Solution s = new Solution();
        assertTrue(s.search(new int[]{5,1,3}, 3));
        assertFalse(s.search(new int[]{1,2,3}, 0));
        assertTrue(s.search(new int[]{1,2,3}, 2));
        assertTrue(s.search(new int[]{2,5,6,0,0,1,2}, 0));
        assertFalse(s.search(new int[]{2,5,6,0,0,1,2}, 3));
    }
}