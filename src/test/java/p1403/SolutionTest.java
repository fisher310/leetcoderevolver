package p1403;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * @author lihailong
 * @since 2021/1/14 0014
 */
public class SolutionTest {

    @Test
    public void minSubsequence() {

        Solution s = new Solution();
        check(List.of(10, 9), s.minSubsequence(new int[] {4, 3, 10, 9, 8}));
        check(List.of(7, 7, 6), s.minSubsequence(new int[] {4, 4, 7, 6, 7}));
        check(List.of(6), s.minSubsequence(new int[] {6}));
    }

    private void check(List<Integer> expected, List<Integer> actual) {
        Assert.assertEquals(expected.size(), actual.size());
        for (int i = 0; i < expected.size(); i++) {
            Assert.assertEquals(expected.get(i), actual.get(i));
        }
    }
}
