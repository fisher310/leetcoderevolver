package p30;

import org.junit.Test;

import java.util.List;

public class SolutionTest {

    @Test
    public void findSubstring() {
        Solution s = new Solution();
        List<Integer> ans = s.findSubstring("barfoothefoobarman", new String[]{"foo", "bar"});
        System.out.println(ans);

        s = new Solution();
        ans = s.findSubstring("wordgoodgoodgoodbestword", new String[]{"word", "good", "best", "word"});
        System.out.println(ans);
    }
}