package p67;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {

    @Test
    public void addBinary() {
        Solution s = new Solution();
        assertEquals("11110", s.addBinary("1111", "1111"));
        assertEquals("100", s.addBinary("11", "1"));
        assertEquals("10101", s.addBinary("1010", "1011"));
    }
}