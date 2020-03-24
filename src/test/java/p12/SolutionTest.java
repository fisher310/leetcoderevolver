package p12;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {

    @Test
    public void intToRoman() {
        Solution solution = new Solution();

        assertEquals("III", solution.intToRoman(3));
        assertEquals("IV", solution.intToRoman(4));
        assertEquals("IX", solution.intToRoman(9));
        assertEquals("LVIII", solution.intToRoman(58));
        assertEquals("MCMXCIV", solution.intToRoman(1994));
    }
}