package p162;

import org.hamcrest.Matcher;
import org.hamcrest.MatcherAssert;
import org.hamcrest.core.AnyOf;
import org.hamcrest.core.Is;
import org.junit.Test;
import org.junit.matchers.JUnitMatchers;

import static org.junit.Assert.*;

/**
 * @author lihailong
 * @since 2021/04/12 10:50:55
 */
public class SolutionTest {

    @Test
    public void findPeakElement() {

        Solution s = new Solution();
        assertEquals(2, s.findPeakElement(new int[]{1, 2, 3, 1}));
        assertEquals(0, s.findPeakElement(new int[]{2}));
        MatcherAssert.assertThat(
                s.findPeakElement(new int[]{2, 1, 3}),
                AnyOf.anyOf(Is.is(0), Is.is(2)));

        assertEquals(2, s.findPeakElement(new int[]{1, 2, 3}));
    }
}