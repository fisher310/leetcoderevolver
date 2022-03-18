package p771;

import org.junit.Assert;

public class Solution {
  public int numJewelsInStones(String jewels, String stones) {
    int[] dict = new int[128];
    for (int i = 0; i < jewels.length(); i++) {
      dict[(int) jewels.charAt(i)] = 1;
    }

    int ans = 0;
    for (int i = 0; i < stones.length(); i++) {
      if (dict[(int) stones.charAt(i)] == 1) {
        ans++;
      }
    }

    return ans;
  }

  public static void main(String[] args) {

    Solution s = new Solution();
    Assert.assertEquals(3, s.numJewelsInStones("aA", "aAAbbbb"));
    Assert.assertEquals(0, s.numJewelsInStones("z", "ZZ"));
  }
}
