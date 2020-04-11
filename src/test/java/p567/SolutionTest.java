package p567;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SolutionTest {

    @Test
    public void checkInclusion() {
        Solution s = new Solution();
        assertTrue(s.checkInclusion("adc", "dcda"));
        assertFalse(s.checkInclusion("hello", "ooolleoooleh"));
        assertTrue(s.checkInclusion("ab", "eidbaooo"));
        assertFalse(s.checkInclusion("ab", "eidboaoo"));
    }
}
