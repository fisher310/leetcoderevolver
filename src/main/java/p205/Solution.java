package p205;

import java.util.HashMap;
import java.util.Map;
/** 同构字符串 */
class Solution {
  public boolean isIsomorphic(String s, String t) {
    if (s == null || t == null) return false;
    return helper(s, t) && helper(t, s);
  }

  boolean helper(String s, String t) {
    Map<Character, Character> map = new HashMap<>();
    int N = s.length();
    for (int i = 0; i < N; i++) {
      char cs = s.charAt(i);
      char ct = t.charAt(i);
      Character mcs = map.get(cs);
      if (mcs == null) {
        map.put(cs, ct);
      } else {
        if (mcs != ct) {
          return false;
        }
      }
    }
    return true;
  }
}
