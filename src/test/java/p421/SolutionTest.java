package p421;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void findMaximumXOR() {
        Solution s = new Solution();
        int max = s.findMaximumXOR(new int[]{3, 10, 5, 25, 2, 8});
        assertEquals(28, max);
    }
}