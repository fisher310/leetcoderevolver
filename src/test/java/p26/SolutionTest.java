package p26;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {

    @Test
    public void removeDuplicates() {
        Solution s = new Solution();
        int ans = s.removeDuplicates(new int[]{1, 1, 2});
        assertEquals(2, ans);
        ans = s.removeDuplicates(new int[]{1, 2, 3, 4, 5});
        assertEquals(5, ans);
        ans = s.removeDuplicates(new int[1]);
        assertEquals(1, ans);
    }
}