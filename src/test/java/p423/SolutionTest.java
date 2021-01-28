package p423;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void originalDigits() {
        Solution s = new Solution();
        assertEquals("012", s.originalDigits("owoztneoer"));
        assertEquals("45", s.originalDigits("fviefuro"));
    }
}