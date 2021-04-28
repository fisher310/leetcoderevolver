package p1839;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author lihailong
 * @since 2021/04/28 17:10:43
 */
public class SolutionTest {

    @Test
    public void longestBeautifulSubstring() {

        Solution s = new Solution();
        assertEquals(13, s.longestBeautifulSubstring("aeiaaioaaaaeiiiiouuuooaauuaeiu"));
    }
}
