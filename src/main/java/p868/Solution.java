package p868;

import org.junit.Assert;

public class Solution {
  public int binaryGap(int n) {
    int p = -1;
    int ans = 0;
    int i = 0;
    while (n != 0) {
      if ((n & 0x1) == 1) {
        if (p != -1) {
          ans = Math.max(ans, i - p);
        }
        p = i;
      }
      n = n >>> 1;
      i++;
    }

    return ans;
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println(s.binaryGap(5));
    Assert.assertEquals(2, s.binaryGap(22));
    Assert.assertEquals(0, s.binaryGap(8));
  }
}
