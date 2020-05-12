package p1248;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {

    @Test
    public void numberOfSubarrays() {
        Solution s = new Solution();
//        assertEquals(2, s.numberOfSubarrays(new int[] {1, 1, 2, 1, 1}, 3));
//        assertEquals(0, s.numberOfSubarrays(new int[] {2, 4, 6}, 1));
        assertEquals(16, s.numberOfSubarrays(new int[] {2, 2, 2, 1, 2, 2, 1, 2, 2, 1}, 2));
    }
}
