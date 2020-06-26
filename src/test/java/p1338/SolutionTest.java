package p1338;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {

    @Test
    public void minSetSize() {

        Solution s = new Solution();
        assertEquals(2, s.minSetSize(new int[]{3,3,3,3,5,5,5,2,2,7}));
        assertEquals(1, s.minSetSize(new int[]{7,7,7,7,7,7}));
        assertEquals(1, s.minSetSize(new int[]{1,9}));
        assertEquals(1, s.minSetSize(new int[]{1000,1000,3,7}));
        assertEquals(5, s.minSetSize(new int[]{1,2,3,4,5,6,7,8,9,10}));
    }
}