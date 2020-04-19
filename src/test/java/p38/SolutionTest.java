package p38;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {

    @Test
    public void countAndSay() {
        Solution s = new Solution();
        assertEquals("312211", s.countAndSay(6));
        assertEquals("1", s.countAndSay(1));
        assertEquals("1211", s.countAndSay(4));
    }
}
