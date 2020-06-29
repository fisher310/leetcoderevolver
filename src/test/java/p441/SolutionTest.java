package p441;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {

    @Test
    public void arrangeCoins() {

        Solution s = new Solution();
        assertEquals(60070, s.arrangeCoins(1804289383));
        assertEquals(1, s.arrangeCoins(1));
        assertEquals(44, s.arrangeCoins(1000));
        assertEquals(2, s.arrangeCoins(5));
        assertEquals(3, s.arrangeCoins(8));

    }
}