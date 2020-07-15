package p32;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void longestValidParentheses() {
        Solution s = new Solution();
        assertEquals(10, s.longestValidParentheses("(()(()))()"));
        assertEquals(6, s.longestValidParentheses("()(()))()"));
    }
}
