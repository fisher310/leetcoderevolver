package p636;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;

public class SolutionTest {

    @Test
    public void exclusiveTime() {

        Solution s = new Solution();

        List<String> log;
        log = Arrays.asList("0:start:0", "0:start:1", "0:start:2", "0:end:3", "0:end:4", "0:end:5");
        assertArrayEquals(new int[] {6}, s.exclusiveTime(1, log));

        log = Arrays.asList("0:start:0", "0:start:2", "0:end:5", "0:start:6", "0:end:6", "0:end:7");
        assertArrayEquals(new int[] {8}, s.exclusiveTime(1, log));

        log = Arrays.asList("0:start:0", "1:start:2", "1:end:5", "0:end:6");
        assertArrayEquals(new int[] {3, 4}, s.exclusiveTime(2, log));

        log = Arrays.asList("0:start:0", "0:start:2", "0:end:5", "1:start:7", "1:end:7", "0:end:8");
        assertArrayEquals(new int[] {8, 1}, s.exclusiveTime(2, log));
    }
}
