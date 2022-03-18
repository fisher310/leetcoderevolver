package p804;

import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;

public class Solution {

  public int uniqueMorseRepresentations(String[] words) {

    String[] morse =
        new String[] {
          ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..",
          "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-",
          "-.--", "--.."
        };

    Set<String> s = new HashSet<>();
    for (String word : words) {
      StringBuilder sb = new StringBuilder();
      for (int i = 0; i < word.length(); i++) {
        sb.append(morse[word.charAt(i) - 'a']);
      }
      s.add(sb.toString());
    }
    return s.size();
  }
  public static void main(String[] args) {
       
    Solution s = new Solution();
    Assert.assertEquals("test01", 2,  s.uniqueMorseRepresentations(new String[]{"gin", "zen", "gig", "msg"}));
  }
}
