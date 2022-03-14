package p1601;

import org.junit.Assert;
import util.ArrayUtils;

import java.util.*;

/**
 * @author lihailong
 * @since 2022-02-28 10:41:12
 */
class Solution {
  public int maximumRequests(int n, int[][] requests) {

    Map<Integer, Set<Integer>> out = new HashMap<>();

    int self = 0;
    boolean[] visited = new boolean[requests.length];
    for (int i = 0; i < requests.length; i++) {
      int from = requests[i][0];
      int to = requests[i][1];
      if (from == to) {
        self++;
        visited[i] = true;
        continue;
      }
      Set<Integer> no = out.getOrDefault(from, new HashSet<>());
      no.add(i);
      out.put(from, no);

      //      Set<Integer> ni = in.getOrDefault(to, new HashSet<>());
      //      ni.add(i);
      //      in.put(to, ni);
    }

    if (self == requests.length) {
      return self;
    }

    int ans = 0;
    for (int i = 0; i < requests.length; i++) {
      if (!visited[i]) {
        ans = Math.max(ans, self + dfs(requests, i, out, visited, 0));
      }
    }
    return ans;
  }

  int dfs(int[][] requests, int n, Map<Integer, Set<Integer>> out, boolean[] visited, int level) {
    int[] request = requests[n];
    if (!out.containsKey(request[1])) {
      return 0;
    }

    Set<Integer> from_set = out.get(request[1]);
    int ans = 0;
    for (int from : from_set) {
      if (!visited[from]) {
        visited[from] = true;
        System.out.println("process request ("+n+") go to next level (current="+level+") from " + request[1] + ", use request (" + from + "). ans =" + ans);
        ans = Math.max(ans, 1 + dfs(requests, from, out, visited, level + 1));
        visited[from] = false;
      }
    }
    System.out.println(Arrays.toString(request) + " (level=" + level + "): ans = " + ans);
    if (level == 0) {
      System.out.println("---------------------");
    }

    return ans;
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    Assert.assertEquals(
        4,
        s.maximumRequests(3, ArrayUtils.getInput2("[[1,2],[1,2],[2,2],[0,2],[2,1],[1,1],[1,2]]")));
    Assert.assertEquals(3, s.maximumRequests(3, new int[][] {{0, 0}, {1, 2}, {2, 1}}));
    Assert.assertEquals(4, s.maximumRequests(4, ArrayUtils.getInput2("[[0,3],[3,1],[1,2],[2,0]]")));
    Assert.assertEquals(
        5, s.maximumRequests(5, new int[][] {{0, 1}, {1, 0}, {0, 1}, {1, 2}, {2, 0}, {3, 4}}));
  }
}
