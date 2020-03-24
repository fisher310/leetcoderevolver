package p13;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {

    @Test
    public void romanToInt() {
        Solution s = new Solution();
        assertEquals(3, s.romanToInt("III"));
        assertEquals(4, s.romanToInt("IV"));
        assertEquals(9, s.romanToInt("IX"));
        assertEquals(58, s.romanToInt("LVIII"));
        assertEquals(1994, s.romanToInt("MCMXCIV"));
        assertEquals(1476, s.romanToInt("MCDLXXVI"));
    }
}