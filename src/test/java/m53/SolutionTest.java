package m53;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {

    @Test
    public void search() {
        Solution s = new Solution();
        assertEquals(1, s.search(new int[] {1, 3}, 1));
        assertEquals(2, s.search(new int[] {2, 2}, 2));
        assertEquals(2, s.search(new int[] {5, 7, 7, 8, 8, 10}, 8));
        assertEquals(0, s.search(new int[] {5, 7, 7, 8, 8, 10}, 6));
    }
}
