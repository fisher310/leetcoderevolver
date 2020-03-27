package p35;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {

    @Test
    public void searchInsert() {
        Solution s = new Solution();
        assertEquals(2, s.searchInsert(new int[]{1, 3, 5, 6}, 5));
        assertEquals(1, s.searchInsert(new int[]{1, 3, 5, 6}, 2));
        assertEquals(4, s.searchInsert(new int[]{1, 3, 5, 6}, 7));
        assertEquals(0, s.searchInsert(new int[]{1, 3, 5, 6}, 0));
    }
}
