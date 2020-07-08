package p720;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/** words = ["a", "banana", "app", "appl", "ap", "apply", "apple"] 输出: "apple" */
class Solution {

  public String longestWord(String[] words) {

    Arrays.sort(words);

    String ans = "";

    Set<String> set = new HashSet<>();

    for (int i = 0; i < words.length; i++) {

      String s = words[i];
      if (s.length() == 1) {
        set.add(s);
        if (ans.length() < s.length()) ans = s;
      } else {
        String prefix = s.substring(0, s.length() - 1);
        if (set.contains(prefix)) {
          if (ans.length() < s.length()) ans = s;
          set.add(s);
        }
      }
    }

    return ans;
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println(
        s.longestWord(new String[] {"a", "banana", "app", "appl", "ap", "apply", "apple"}));

    System.out.println(
        s.longestWord(
            new String[] {
              "yo", "ew", "fc", "zrc", "yodn", "fcm", "qm", "qmo", "fcmz", "z", "ewq", "yod",
              "ewqz", "y"
            }));
  }
}
