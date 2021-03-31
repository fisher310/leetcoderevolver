package p1759;

import junit.framework.TestCase;

/**
 * @author lihailong
 * @since 2021-03-30 21:05:22
 */
public class SolutionTest extends TestCase {

    public void testCountHomogenous() {

        Solution s = new Solution();
        assertEquals(13, s.countHomogenous("abbcccaa"));
        assertEquals(2, s.countHomogenous("xy"));
        assertEquals(15, s.countHomogenous("zzzzz"));

    }
}