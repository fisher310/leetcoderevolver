package p16;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {

    @Test
    public void threeSumClosest() {
        Solution s = new Solution();
//        assertEquals(2, s.threeSumClosest(new int[]{-1, 2, 1, -4}, 1));
//        assertEquals(2, s.threeSumClosest(new int[]{-4, -3, 2, 9, 5, 7}, 4));
        assertEquals(82, s.threeSumClosest(new int[]{1, 2, 4, 8, 16, 32, 64, 128}, 82));
    }
}