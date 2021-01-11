package p880;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author lihailong
 * @since 2021/1/9 0009
 */
public class SolutionTest {

    @Test
    public void decodeAtIndex() {

        Solution s = new Solution();
        assertEquals("o", s.decodeAtIndex("leet2code3", 10));
    }
}
