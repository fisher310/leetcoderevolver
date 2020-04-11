package p290;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SolutionTest {

    @Test
    public void wordPattern() {
        Solution s = new Solution();
        assertTrue(s.wordPattern("abba", "dog cat cat dog"));
        assertFalse(s.wordPattern("abba", "dog cat cat fish"));
        assertFalse(s.wordPattern("aaaa", "dog cat cat dog"));
        assertFalse(s.wordPattern("abba", "dog dog dog dog"));
        assertTrue(s.wordPattern("abc", "b c a"));
    }
}
