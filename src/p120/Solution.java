package p120;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @fomatter:off
 *     <p>给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
 *     <p>例如，给定三角形：
 *     <p>[ [2], <br>
 *     [3,4], <br>
 *     [6,5,7], <br>
 *     [4,1,8,3] ] <br>
 *     自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 *     <p>说明：
 *     <p>如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。
 *     <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/triangle
 *     著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @fomatter:off
 */
class Solution {

  public int minimumTotal(List<List<Integer>> triangle) {
    List<Integer> last = triangle.get(triangle.size() - 1);
    Integer[] mini = last.toArray(new Integer[] {});
    for (int i = triangle.size() - 2; i >= 0; i--) {
      for (int j = 0; j < triangle.get(i).size(); j++) {
        mini[j] = triangle.get(i).get(j) + Math.min(mini[j], mini[j + 1]);
      }
    }
    return mini[0];
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    List<List<Integer>> triangle = new ArrayList<>();
    triangle.add(Arrays.asList(2));
    triangle.add(Arrays.asList(3, 4));
    triangle.add(Arrays.asList(6, 5, 7));
    triangle.add(Arrays.asList(4, 1, 8, 3));
    System.out.println(s.minimumTotal(triangle));
  }
}
