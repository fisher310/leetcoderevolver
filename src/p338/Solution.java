package p338;

public class Solution {
  public int[] countBits(final int num) {
    final int[] ans = new int[num + 1];
    for (int i = 1; i <= num; i++) {
      ans[i] = ans[i & (i - 1)] + 1;
    }
    return ans;
  }
}
