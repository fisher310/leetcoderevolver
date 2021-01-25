package p1018;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * @author lihailong
 * @since 2021/1/14 0014
 */
public class SolutionTest {

    @Test
    public void prefixesDivBy5() {
        Solution s = new Solution();

        check(
                List.of(
                        false, false, false, false, false, false, false, false, false, false, false,
                        false, false, false, false, false, false, false, false, false, false, false,
                        false, false, false, false, false, false, false, false, false, true, false,
                        false, true, true, true, true, false),
                s.prefixesDivBy5(
                        new int[] {
                            1, 0, 0, 1, 0, 1, 0, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0,
                            1, 0, 1, 0, 0, 0, 0, 1, 1, 0, 1, 0, 0, 0, 1
                        }));
        check(List.of(true, false, false), s.prefixesDivBy5(new int[] {0, 1, 1}));
        check(List.of(false, false, false), s.prefixesDivBy5(new int[] {1, 1, 1}));
        check(
                List.of(true, false, false, false, true, false),
                s.prefixesDivBy5(new int[] {0, 1, 1, 1, 1, 1}));
    }

    private void check(List<Boolean> expected, List<Boolean> ans) {
        for (int i = 0; i < expected.size(); i++) {
            assertEquals(expected.get(i), ans.get(i));
        }
    }
}
