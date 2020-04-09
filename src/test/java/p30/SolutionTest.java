package p30;

import org.junit.Test;

import java.util.List;

public class SolutionTest {

  @Test
  public void findSubstring() {
    Solution s = new Solution();
    List<Integer> ans1 = s.findSubstring("barfoothefoobarman", new String[] {"foo", "bar"});
    System.out.println(ans1);

    List<Integer> ans2 =
        s.findSubstring("wordgoodgoodgoodbestword", new String[] {"word", "good", "best", "word"});
    System.out.println(ans2);

    System.out.println(
        s.findSubstring("wordgoodgoodgoodbestword", new String[] {"word", "good", "best", "good"}));
  }
}
