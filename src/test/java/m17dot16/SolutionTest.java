package m17dot16;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {

    @Test
    public void message() {

        Solution s = new Solution();
        assertEquals(4, s.message(new int[]{2, 1, 1, 2}));
    }
}
