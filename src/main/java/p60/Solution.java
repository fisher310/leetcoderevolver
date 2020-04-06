package p60;

/** 第K个排列 */
class Solution {
  private int kth = 0;
  private String ans;

  public String getPermutation(int n, int k) {
    kth = 0;
    ans = "";
    int[] visited = new int[n + 1];
    dfs(n, k, visited, new StringBuilder());
    return ans;
  }

  private void dfs(int n, int k, int[] visited, StringBuilder sb) {

    for (int i = 1; i <= n; i++) {
      if (visited[i] == 0) {
        sb.append(i);
        if (sb.length() == n) {
          //          System.out.println(sb.toString());
          if (++kth == k) {
            ans = sb.toString();
            return;
          }
        }
        visited[i] = 1;
        dfs(n, k, visited, sb);
        visited[i] = 0;
        sb.setLength(sb.length() - 1);
      }
    }
  }
}
