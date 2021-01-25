package p959;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author lihailong
 * @since 2021/1/25 0025
 */
public class SolutionTest {

    @Test
    public void regionsBySlashes() {
        System.out.println("\\/\\/".length());

        Solution s = new Solution();
        Assert.assertEquals(3, s.regionsBySlashes(new String[] {"//", "/ "}));
        Assert.assertEquals(5, s.regionsBySlashes(new String[] {"/\\", "\\/"}));
        Assert.assertEquals(4, s.regionsBySlashes(new String[] {"\\/", "/\\"}));
        Assert.assertEquals(1, s.regionsBySlashes(new String[] {" /", "  "}));
        Assert.assertEquals(2, s.regionsBySlashes(new String[] {" /", "/ "}));
    }
}
