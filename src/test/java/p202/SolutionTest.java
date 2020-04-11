package p202;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class SolutionTest {

    @Test
    public void isHappy() {
        Solution s = new Solution();
        assertTrue(s.isHappy(19));
    }
}
