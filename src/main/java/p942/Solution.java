package p942;

import java.util.*;

public class Solution {
  public int[] diStringMatch(String s) {

    // 0 - s.length + 1;
    int l = 0, r = s.length();
    int[] res = new int[s.length() + 1];

    char[] arr = s.toCharArray();
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == 'I') {
        res[i] = l++;
      } else {
        res[i] = r--;
      }
    }
    res[s.length()] = res[s.length() - 1] == l ? r : l;

    return res;
  }

  public static void main(String[] args) {

    Solution s = new Solution();
    System.out.println(Arrays.toString(s.diStringMatch("IDID")));
    System.out.println(Arrays.toString(s.diStringMatch("DIDI")));
    System.out.println(Arrays.toString(s.diStringMatch("III")));
    System.out.println(Arrays.toString(s.diStringMatch("DDD")));
  }
}
