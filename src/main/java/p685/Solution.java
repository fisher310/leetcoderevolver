package p685;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/** 冗余连接 二 【困难】 */
class Solution {
  public int[] findRedundantDirectedConnection(int[][] edges) {
    if (null == edges) return null;
    UFD ufd = new UFD(edges.length + 1);
    Map<Integer, LinkedList<int[]>> inDegree = new HashMap<>();
    for (int[] edge : edges) {
      LinkedList<int[]> inEdges = inDegree.getOrDefault(edge[1], new LinkedList<>());
      inEdges.addFirst(edge);
      inDegree.put(edge[1], inEdges);
      if (inEdges.size() > 1) {
        for (int[] e : inEdges) {
          if (!UFD.isCycle(edges, e)) {
            return e;
          }
        }
      }
    }

    for (int[] edge : edges) {
      if (ufd.isConnected(edge[0], edge[1])) {
        return edge;
      }
      ufd.union(edge[0], edge[1]);
    }

    return null;
  }

  private static class UFD {
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
        parent[qr] = pr;
      }
    }

    static boolean isCycle(int[][] edges, int[] except) {
      UFD ufd = new UFD(edges.length + 1);
      for (int i = 0; i < edges.length; i++) {
        int[] e = edges[i];
        if (e[0] == except[0] && e[1] == except[1]) {
          continue;
        }
        if (ufd.isConnected(e[0], e[1])) {
          return true;
        }
        ufd.union(e[0], e[1]);
      }
      return false;
    }
  }
}
