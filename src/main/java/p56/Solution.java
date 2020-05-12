package p56;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/** 合并区间 */
class Solution {
  public int[][] merge(int[][] intervals) {
    if (null == intervals || intervals.length == 0) return intervals;

    Arrays.sort(
        intervals,
        (o1, o2) -> {
          if (o1[0] == o2[0]) {
            return Integer.compare(o1[1], o1[1]);
          }
          return Integer.compare(o1[0], o2[0]);
        });
    List<int[]> list = new LinkedList<>();

    int[] pre = intervals[0];
    for (int i = 1; i < intervals.length; i++) {
      int[] curr = intervals[i];
      if (curr[0] <= pre[1]) {
        pre[1] = Math.max(pre[1], curr[1]);
      } else {
        list.add(pre);
        pre = curr;
      }
    }
    list.add(pre);

    int[][] ans = new int[list.size()][];

    int i = 0;
    for (int[] arr : list) {
      ans[i++] = arr;
    }
    return ans;
  }

  public static void main(String[] args) {
    //    int[][] intervals = new int[][] {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
    //    int[][] intervals = new int[][] {{1, 4}, {4, 5}};
    //    int[][] intervals = new int[][] {{1, 4}, {1, 4}};
    int[][] intervals = new int[][] {{1, 4}, {2, 3}};
    Solution s = new Solution();
    int[][] merge = s.merge(intervals);
    for (int[] arr : merge) {
      System.out.println(Arrays.toString(arr));
    }
  }
}
