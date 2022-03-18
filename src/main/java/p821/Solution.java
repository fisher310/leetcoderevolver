package p821;

import org.junit.Assert;

public class Solution {
  public int[] shortestToChar(String s, char c) {

    int[] answer = new int[s.length()];
    int pre = -1;
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == c) {
        for (int j = pre + 1; j <= i; j++) {
          if (pre == -1) {
            answer[j] = i - j;
          } else {
            answer[j] = Math.min(i - j, j - pre);
          }
        }
        pre = i;
      }
    }

    for (int i = pre + 1, j = 1; i < s.length(); i++, j++) {
      answer[i] = j;
    }

    return answer;
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    Assert.assertArrayEquals(
        new int[] {3, 2, 1, 0, 1, 0, 0, 1, 2, 2, 1, 0}, s.shortestToChar("loveleetcode", 'e'));
    Assert.assertArrayEquals(new int[] {3, 2, 1, 0}, s.shortestToChar("aaab", 'b'));
  }
}
