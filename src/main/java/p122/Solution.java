package p122;

import org.junit.Assert;

class Solution {

  public int maxProfit(int[] prices) {

    int ans = 0;

    for (int i = 0; i < prices.length - 1; i++) {
      if (prices[i + 1] > prices[i]) {
        ans += prices[i + 1] - prices[i];
      }
    }

    return ans;
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    Assert.assertEquals(7, s.maxProfit(new int[] {7, 1, 5, 3, 6, 4}));
    Assert.assertEquals(4, s.maxProfit(new int[] {1, 2, 3, 4, 5}));
    Assert.assertEquals(0, s.maxProfit(new int[] {7, 6, 4, 3, 1}));
  }
}
