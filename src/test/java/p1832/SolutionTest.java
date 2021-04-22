package p1832;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author lihailong
 * @since 2021/04/20 14:09:20
 */
public class SolutionTest {

    @Test
    public void checkIfPangram() {

        Solution s = new Solution();
        assertTrue(s.checkIfPangram("thequickbrownfoxjumpsoverthelazydog"));
        assertFalse(s.checkIfPangram("leetcode"));
    }
}
