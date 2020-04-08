package m13;

/** 机器人的运动范围 */
class Solution {

  private int[] dx = {1, 0};
  private int[] dy = {0, 1};

  public int movingCount(int m, int n, int k) {
    boolean[][] visited = new boolean[m][n];
    visited[0][0] = true;
    int ans = 1;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (sum(i, j) > k) continue;

        if ((i - 1 >= 0 && visited[i - 1][j]) || (j - 1 >= 0) && visited[i][j - 1]) {
          ans++;
          visited[i][j] = true;
        }
      }
    }
    return ans;
  }

  //  public int movingCount(int m, int n, int k) {
  //    Queue<int[]> queue = new LinkedList<>();
  //    queue.offer(new int[] {0, 0});
  //    int ans = 0;
  //    boolean[][] visited = new boolean[m][n];
  //    visited[0][0] = true;
  //    while (!queue.isEmpty()) {
  //      int[] point = queue.poll();
  //      ans++;
  //      for (int i = 0; i < 2; i++) {
  //        int cx = point[0] + dx[i];
  //        int cy = point[1] + dy[i];
  //        if (cx >= 0 && cx < m && cy >= 0 && cy < n && !visited[cx][cy] && sum(cx, cy) <= k) {
  //          queue.offer(new int[] {cx, cy});
  //          visited[cx][cy] = true;
  //        }
  //      }
  //    }
  //    return ans;
  //  }

  private int sum(int i, int j) {
    int sum = 0;
    while (i > 0) {
      sum += i % 10;
      i /= 10;
    }
    while (j > 0) {
      sum += j % 10;
      j /= 10;
    }
    return sum;
  }
}
