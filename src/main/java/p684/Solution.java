package p684;

import org.junit.Assert;

class Solution {
  public int[] findRedundantConnection(int[][] edges) {
    if (null == edges) return null;
    int[] ufd = new int[edges.length + 1];
    for (int i = 0; i < ufd.length; i++) {
      ufd[i] = i;
    }
    for (int[] edge : edges) {
      int pu = ufd[edge[0]];
      int pv = ufd[edge[1]];

      if (pu != pv) {
        for (int i = 0; i < ufd.length; i++) {
          if (ufd[i] == pv) {
            ufd[i] = pu;
          }
        }
      } else {
        return edge;
      }
    }
    return null;
  }

  static class UFD {
    private int[] parent;

    public UFD(int n) {
      parent = new int[n];
      for (int i = 0; i < n; i++) {
        parent[i] = i;
      }
    }

    int find(int p) {
      while (p != parent[p]) {
        p = parent[p];
      }
      return p;
    }

    boolean isConnected(int p, int q) {
      return find(p) == find(q);
    }

    void union(int p, int q) {
      int pr = find(p);
      int qr = find(q);
      if (pr != qr) {
        parent[pr] = qr;
      }
    }
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    //    int[] ans = s.findRedundantConnection(new int[][] {{1, 4}, {3, 4}, {1, 3}, {1, 2}, {4,
    // 5}});
    int[] ans =
        s.findRedundantConnection(
            new int[][] {
              {3, 7}, {1, 4}, {2, 8}, {1, 6}, {7, 9}, {6, 10}, {1, 7}, {2, 3}, {8, 9}, {5, 9}
            });
    Assert.assertArrayEquals("t1", new int[] {8, 9}, ans);
    ans = s.findRedundantConnection(new int[][] {{1, 2}, {1, 3}, {2, 3}});
    Assert.assertArrayEquals(new int[] {2, 3}, ans);
    ans = s.findRedundantConnection(new int[][] {{1, 2}, {2, 3}, {3, 4}, {1, 4}, {1, 5}});
    Assert.assertArrayEquals(new int[] {1, 4}, ans);
  }
}
