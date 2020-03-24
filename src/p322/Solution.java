package p322;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 *
 * <p>示例 1:
 *
 * <p>输入: coins = [1, 2, 5], amount = 11 输出: 3 解释: 11 = 5 + 5 + 1 示例 2:
 *
 * <p>输入: coins = [2], amount = 3 输出: -1 说明: 你可以认为每种硬币的数量是无限的。
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/coin-change
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {
  public int coinChange(int[] coins, int amount) {
    Arrays.sort(coins);
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0, n = coins.length; i < n; i++) {
      map.put(coins[i], i);
    }
    for (int i = coins.length - 1; i >= 0; i--) {
      int remind = amount;
      int j = i;
      int count = 0;
      while (j >= 0) {
        while (remind > 0) {
          if (map.containsKey(remind)) {
            count++;
            return count;
          }
          remind -= coins[j];
          count++;
        }
        if (remind == 0) {
          return count;
        }
        remind += coins[j];
        count--;
        j--;
      }
    }

    return -1;
  }

  public static void main(String[] args) {
    //    int[] input = new int[] {1, 2, 5};
    //    int[] input = new int[] {2};
    int[] input = new int[] {186, 419, 83, 408};
    int num = 6249;
    Solution s = new Solution();
    int ans = s.coinChange(input, num);
    System.out.println(ans);
  }
}
