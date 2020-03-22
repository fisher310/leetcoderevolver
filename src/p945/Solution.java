package p945;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定整数数组 A，每次 move 操作将会选择任意 A[i]，并将其递增 1。
 *
 * <p>返回使 A 中的每个值都是唯一的最少操作次数。
 *
 * <p>示例 1:
 *
 * <p>输入：[1,2,2] 输出：1 解释：经过一次 move 操作，数组将变为 [1, 2, 3]。 示例 2:
 *
 * <p>输入：[3,2,1,2,1,7] 输出：6 解释：经过 6 次 move 操作，数组将变为 [3, 4, 1, 2, 5, 7]。 可以看出 5 次或 5 次以下的 move
 * 操作是不能让数组的每个值唯一的。
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/minimum-increment-to-make-array-unique
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {
  public int minIncrementForUnique(int[] A) {
    if (A == null || A.length == 1) return 0;
    Map<Integer, Integer> map = new HashMap<>(A.length);
    int total = 0;
    for (int a : A) {
      if (!map.containsKey(a)) {
        map.put(a, 1);
        continue;
      }

      while (map.containsKey(a)) {
        total++;
        a++;
      }
      map.put(a, 1);
    }

    return total;
  }

  public static void main(String[] args) throws IOException {
    //    int count = s.minIncrementForUnique(new int[] {1, 2, 2});
    //    int count = s.minIncrementForUnique(new int[] {3, 2, 1, 2, 1, 7});
    List<Integer> list = new ArrayList<>();
    List<String> lines =
        Files.readAllLines(
            Paths.get("D:\\spaces\\github.com\\leetcodesolver\\src\\p945\\array.txt"));
    for (String line : lines) {
      String[] nums = line.split(",");
      for (String n : nums) {
        try {
          String m = n.trim();
          if (!"".equals(m)) {
            list.add(Integer.parseInt(m.trim()));
          }
        } catch (Exception e) {
          System.out.println(e.getMessage());
        }
      }
    }
    int[] testCase = list.stream().mapToInt(Integer::intValue).toArray();
    Solution s = new Solution();
    long start = System.currentTimeMillis();
    int count = s.minIncrementForUnique(testCase);
    long duration = System.currentTimeMillis() - start;
    System.out.println(count + ", duration:" + duration / 1000 + "s");
  }
}
