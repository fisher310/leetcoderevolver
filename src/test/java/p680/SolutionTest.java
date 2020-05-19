package p680;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class SolutionTest {

    @Test
    public void validPalindrome() {
        Solution s = new Solution();
        assertTrue(s.validPalindrome("aba"));
        assertTrue(s.validPalindrome("abca"));
    }
}