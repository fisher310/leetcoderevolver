package p496;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void nextGreaterElement() {
        Solution s = new Solution();
        assertArrayEquals(
                new int[] {-1, 3, -1},
                s.nextGreaterElement(new int[] {4, 1, 2}, new int[] {1, 3, 4, 2}));
        assertArrayEquals(
                new int[] {3, -1},
                s.nextGreaterElement(
                        new int[] {
                            2, 4,
                        },
                        new int[] {1, 2, 3, 4}));
    }
}
