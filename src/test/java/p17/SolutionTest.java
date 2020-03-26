package p17;

import org.junit.Test;

import java.util.List;

public class SolutionTest {

    @Test
    public void letterCombinations() {
        Solution s = new Solution();
        List<String> ans = s.letterCombinations("23");
        System.out.println(ans);
    }

    @Test
    public void testCodePoint() {
        System.out.println(0x010000);
    }
}