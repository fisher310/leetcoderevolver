package p28;

import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class SolutionTest {

    @Test
    public void strStr() throws IOException {
        Solution s = new Solution();
        assertEquals(2, s.strStr("hello", "ll"));
        assertEquals(-1, s.strStr("aaaaa", "bba"));
        assertEquals(-1, s.strStr("aaa", "aaaa"));
        assertEquals(0, s.strStr("aaa", "aaa"));
        assertEquals(4, s.strStr("mississippi", "issip"));

        List<String> lines = Files.readAllLines(Paths.get("D:\\spaces\\github.com\\leetcodesolver\\src\\main\\java\\p28\\test.txt"));
        assertEquals(-1, s.strStr(lines.get(0), lines.get(1)));

    }
}
