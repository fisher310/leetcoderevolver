package p523;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class SolutionTest {

    @Test
    public void checkSubarraySum() {
        Solution s = new Solution();
        assertTrue(s.checkSubarraySum(new int[] {23, 2, 4, 6, 7}, 6));
        assertTrue(s.checkSubarraySum(new int[] {23, 2, 6, 4, 7}, 6));
    }
}
