package p279;

import java.util.LinkedList;

/** 完全平方数 */
class Solution {

  public int numSquares(int n) {

    LinkedList<int[]> queue = new LinkedList<>();
    queue.offer(new int[] {n, 0});
    boolean[] visited = new boolean[n + 1];
    visited[n] = true;
    while (!queue.isEmpty()) {
      int[] p = queue.poll();
      int m = p[0], step = p[1];

      for (int i = 1; ; i++) {
        int remind = m - i * i;
        if (remind < 0) break;
        else if (remind == 0) return step + 1;
        else if (!visited[remind]) {
          queue.offer(new int[] {remind, step + 1});
          visited[remind] = true;
        }
      }
    }

    throw new IllegalArgumentException();
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    int ans = s.numSquares(120);
    System.out.println(ans);
  }
}
