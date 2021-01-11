package offer33;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author lihailong
 * @since 2021/1/4 0004
 */
public class SolutionTest {

    @Test
    public void verifyPostorder() {
        Solution s = new Solution();
        assertTrue(s.verifyPostorder(new int[] {1, 3, 2, 6, 5}));
        assertFalse(s.verifyPostorder(new int[] {1, 6, 3, 2, 5}));
    }
}
