package p806;

import org.junit.Assert;

public class Solution {

  public int[] numberOfLines(int[] widths, String s) {

    int lines = 0;
    int len = 0;
    for (int i = 0; i < s.length(); i++) {
      int w = widths[s.charAt(i) - 'a'];
      if (len + w > 100) {
        lines++;
        len = w;
      } else {
        len += w;
      }
    }
    if (len > 0) {
      lines++;
    }

    return new int[] {lines, len};
  }

  public static void main(String[] args) {

    Solution s = new Solution();
    Assert.assertArrayEquals(
        "test01",
        new int[] {3, 60},
        s.numberOfLines(
            new int[] {
              10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10,
              10, 10, 10, 10, 10
            },
            "abcdefghijklmnopqrstuvwxyz"));
    Assert.assertArrayEquals(
        "test02",
        new int[] {2, 4},
        s.numberOfLines(
            new int[] {
              4, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10,
              10, 10, 10, 10
            },
            "bbbcccdddaaa"));
  }
}
