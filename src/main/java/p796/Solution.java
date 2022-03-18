package p796;

import java.util.*;

/** 输入: s = "abcde", goal = "cdeab" 输出: true */
public class Solution {
  public boolean rotateString(String s, String goal) {
    if (s.length() != goal.length()) {
      return false;
    }

    for (int i = 0; i < s.length(); i++) {
      if (equals(s, goal, i)) {
        return true;
      }
    }
    return false;
  }

  boolean equals(String s, String goal, final int p) {
    int i = p;
    int j = 0;
    do {
      if (s.charAt(i) != goal.charAt(j)) {
        return false;
      }
      i++;
      j++;
      if (i == s.length()) {
        i = 0;
      }
    } while (i != p && j < goal.length());

    return true;
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println(s.rotateString("abcde", "cdeab"));
    System.out.println(s.rotateString("abcde", "abced"));
  }
}
