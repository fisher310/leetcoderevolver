package p1446;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author lihailong
 * @since 2021/1/9 0009
 */
public class SolutionTest {

    @Test
    public void maxPower() {

        Solution s = new Solution();
        assertEquals(2, s.maxPower("leetcode"));
        assertEquals(5, s.maxPower("abbcccddddeeeeedcba"));
        assertEquals(5, s.maxPower("triplepillooooow"));
        assertEquals(11, s.maxPower("hooraaaaaaaaaaay"));
        assertEquals(1, s.maxPower("tourist"));
    }
}
