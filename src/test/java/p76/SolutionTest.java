package p76;

import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class SolutionTest {

    @Test
    public void minWindow() throws IOException {
        Solution s = new Solution();
        List<String> lines =
                Files.readAllLines(
                        Paths.get(
                                "D:\\spaces\\github.com\\leetcodesolver\\src\\main\\java\\p76\\tests.txt"));
        long start = System.currentTimeMillis();
        String ans = s.minWindow(lines.get(0), lines.get(1));
        long duration = System.currentTimeMillis() - start;
        System.out.println(ans);
        System.out.println(duration);
        assertEquals("", s.minWindow("a", "aa"));
        assertEquals("a", s.minWindow("a", "a"));
        assertEquals("BANC", s.minWindow("ADOBECODEBANC", "ABC"));
    }
}
