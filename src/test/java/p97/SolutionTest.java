package p97;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author lihailong
 * @since 2021-04-08 12:41:14
 */
public class SolutionTest {

    @Test
    public void isInterleave() {

        Solution s = new Solution();

        assertTrue(s.isInterleave("aabcc", "dbbca", "aadbbcbcac"));
    }
}