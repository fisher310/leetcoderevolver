package p860;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author lihailong
 * @since 2020/12/10 0010
 */
public class SolutionTest {

    @Test
    public void lemonadeChange() {
        Solution s = new Solution();
        assertTrue(s.lemonadeChange(new int[] {5, 5, 5, 10, 20}));
        assertTrue(s.lemonadeChange(new int[] {5, 5, 10}));
        assertFalse(s.lemonadeChange(new int[] {10, 10}));
        assertFalse(s.lemonadeChange(new int[] {5, 5, 10, 10, 20}));
    }
}
