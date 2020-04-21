package p560;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {

    @Test
    public void subarraySum() {
        Solution s = new Solution();
        assertEquals(2, s.subarraySum(new int[]{1,1,1}, 2));
    }
}