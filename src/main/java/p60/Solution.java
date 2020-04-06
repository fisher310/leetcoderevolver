package p60;

import java.util.ArrayList;
import java.util.List;

/** 第K个排列 */
class Solution {
  private int kth = 0;
  private String ans;

  public String getPermutation(int n, int k) {
    int[] factories = new int[n];
    List<Integer> nums = new ArrayList<>();
    nums.add(1);

    factories[0] = 1;
    for (int i = 1; i < n; i++) {
      factories[i] = i * factories[i - 1];
      nums.add(i + 1);
    }

    --k;
    StringBuilder sb = new StringBuilder();
    for (int i = n - 1; i > -1; i--) {
      int idx = k / factories[i];
      k -= idx * factories[i];
      sb.append(nums.get(idx));
      nums.remove(idx);
    }

    return sb.toString();
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
