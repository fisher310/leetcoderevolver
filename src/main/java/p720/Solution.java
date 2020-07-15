package p720;

import java.util.HashSet;
import java.util.Set;

/** words = ["a", "banana", "app", "appl", "ap", "apply", "apple"] 输出: "apple" */
class Solution {

  public String longestWord(String[] words) {

    String ans = "";

    Set<String> set = new HashSet<>();

    for (String s : words) {
      set.add(s);
    }

    outer:
    for (int i = 0; i < words.length; i++) {

      String s = words[i];
      if (s.length() > ans.length() || (s.length() == ans.length() && s.compareTo(ans) < 0)) {
        for (int j = 1; j < s.length() - 1; j++) {
          if (!set.contains(s.substring(0, j))) {
            continue outer;
          }
        }
        ans = s;
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
