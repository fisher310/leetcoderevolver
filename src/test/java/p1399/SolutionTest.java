package p1399;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author lihailong
 * @since 2020/12/17 0017
 */
public class SolutionTest {

    @Test
    public void countLargestGroup() {
        Solution s = new Solution();
        assertEquals(2, s.countLargestGroup(2));
        assertEquals(4, s.countLargestGroup(13));
        assertEquals(6, s.countLargestGroup(15));
        assertEquals(5, s.countLargestGroup(24));
    }
}
