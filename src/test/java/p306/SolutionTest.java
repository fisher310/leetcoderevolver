package p306;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SolutionTest {

    @Test
    public void isAdditiveNumber() {
        Solution s = new Solution();
        assertTrue(s.isAdditiveNumber("101"));
        assertTrue(s.isAdditiveNumber("123"));
        assertFalse(s.isAdditiveNumber("1023"));
        assertTrue(s.isAdditiveNumber("112358"));
        assertTrue(s.isAdditiveNumber("199100199"));
    }
}
