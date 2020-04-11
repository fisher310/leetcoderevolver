package p438;

import org.junit.Test;

public class SolutionTest {

    @Test
    public void findAnagrams() {
        Solution s = new Solution();
        System.out.println(s.findAnagrams("cbaebabacd", "abc"));
        System.out.println(s.findAnagrams("abab", "ab"));
    }
}
