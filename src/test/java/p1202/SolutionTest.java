package p1202;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * @author lihailong
 * @since 2021/1/11 0011
 */
public class SolutionTest {

    @Test
    public void smallestStringWithSwaps() {
        Solution s = new Solution();

        assertEquals(
                "abc", s.smallestStringWithSwaps("cba", List.of(List.of(0, 1), List.of(0, 2))));
        assertEquals(
                "abcd",
                s.smallestStringWithSwaps(
                        "dcab", List.of(List.of(0, 3), List.of(1, 2), List.of(0, 2))));
        assertEquals(
                "bacd", s.smallestStringWithSwaps("dcab", List.of(List.of(0, 3), List.of(1, 2))));
    }
}
