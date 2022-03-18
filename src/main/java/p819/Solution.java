package p819;

import java.util.*;

import org.junit.Assert;

public class Solution {

  public String mostCommonWord(String paragraph, String[] banned) {

    paragraph = paragraph.toLowerCase();
    Set<String> banneds = new HashSet<>(Arrays.asList(banned));
    Map<String, Integer> maps = new HashMap<>();
    // !?',;.
    char[] arr = paragraph.toCharArray();
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < arr.length; i++) {
      char c = arr[i];
      if (c == '.' || c == '!' || c == '?' || c == '\'' || c == ',' || c == ';' || c == ' ') {
        if (sb.length() > 0) {
          String s = sb.toString();
          if (!banneds.contains(s)) {
            maps.put(s, maps.getOrDefault(s, 0) + 1);
          }
          sb.setLength(0);
        }
      } else {
        sb.append(c);
      }
    }

    if (sb.length() > 0) {
      String s = sb.toString();
      if (!banneds.contains(s)) {
        maps.put(s, maps.getOrDefault(s, 0) + 1);
      }
    }

    String ans = null;
    int max = 0;
    for (Map.Entry<String, Integer> en : maps.entrySet()) {
      if (en.getValue() > max) {
        ans = en.getKey();
        max = en.getValue();
      }
    }

    return ans;
  }

  public static void main(String[] args) {

    Solution s = new Solution();
    Assert.assertEquals(
        "ball",
        s.mostCommonWord(
            "Bob hit a ball, the hit BALL flew far after it was hit.", new String[] {"hit"}));
  }
}
