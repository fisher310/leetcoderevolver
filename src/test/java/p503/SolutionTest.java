package p503;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void nextGreaterElements() {
        Solution s = new Solution();
        assertArrayEquals(new int[] {2, -1, 2}, s.nextGreaterElements(new int[] {1, 2, 1}));
        assertArrayEquals(new int[] {-1, 4, 5, 5}, s.nextGreaterElements(new int[] {5, 3, 4, 2}));
    }
}
