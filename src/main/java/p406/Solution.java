package p406;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/** 根据身高重建队列 */
class Solution {
  public int[][] reconstructQueue(int[][] people) {
    Arrays.sort(
        people,
        (o1, o2) -> {
          if (o1[0] != o2[0]) {
            return o2[0] - o1[0];
          } else {
            return o1[1] - o2[1];
          }
        });
    List<int[]> list = new ArrayList<>(people.length);
    for (int[] a : people) {
      list.add(a[1], a);
    }

    return list.toArray(new int[][] {});
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    int[][] ans = s.reconstructQueue(new int[][] {{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}});
    for (int[] a : ans) {
      System.out.print(Arrays.toString(a) + ", ");
    }
    System.out.println();
  }
}
