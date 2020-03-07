package p1543;

import java.util.ArrayList;
import java.util.List;

/**
 * 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
 *
 * <p>序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
 *
 * <p>
 *
 * <p>示例 1：
 *
 * <p>输入：target = 9 输出：[[2,3,4],[4,5]] 示例 2：
 *
 * <p>输入：target = 15 输出：[[1,2,3,4,5],[4,5,6],[7,8]]
 *
 * <p>限制：
 *
 * <p>1 <= target <= 10^5
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/he-wei-sde-lian-xu-zheng-shu-xu-lie-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
  public int[][] findContinuousSequence(int target) {
    List<int[]> ans = new ArrayList<int[]>();
    for (int i = 1, n = target / 2 + 1; i < n; i++) {
      int j = i;
      int sum = 0;
      while (sum < target) {
        sum += j++;
      }
      if (sum == target) {
        int[] result = new int[j - i];
        for (int k = i, m = 0; k < j; k++, m++) {
          result[m] = k;
        }
        ans.add(result);
      }
    }
    return ans.toArray(new int[][] {});
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    int[][] ans = s.findContinuousSequence(15);
    for (int[] an : ans) {
      for (int i : an) {
        System.out.print(i + " ");
      }
      System.out.println();
    }
  }
}
