package p1319;

import org.junit.Assert;

import java.util.Arrays;

/**
 * 连通网络的操作次数
 */
class Solution {

    private int[] arr;
    private int[] rank;

    public int makeConnected(int n, int[][] connections) {
        if (connections.length < n - 1) return -1;

        arr = new int[n];
        rank = new int[n];
        Arrays.fill(rank, 1);
        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }
        int count = n;

        for (int[] connection : connections) {
            int p = connection[0];
            int q = connection[1];
            if (!connected(p, q)) {
                union(p, q);
                count--;
            }
        }

        return count - 1;
    }

    int find(int p) {
        if (p != arr[p]) {
            arr[p] = find(arr[p]);
        }
        return arr[p];
    }

    void union(int p, int q) {
        int pp = find(p);
        int qq = find(q);
        if (pp == qq) return;
        if (rank[pp] < rank[qq]) {
            arr[pp] = qq;
            rank[qq] += rank[pp];
        } else {
            arr[qq] = pp;
            rank[pp] += rank[qq];
        }
    }

    boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        Assert.assertEquals(1, s.makeConnected(4, new int[][]{{0, 1}, {0, 2}, {1, 2}}));
        Assert.assertEquals(2, s.makeConnected(6, new int[][]{{0, 1}, {0, 2}, {0, 3}, {1, 3}, {1, 2}}));
        Assert.assertEquals(0, s.makeConnected(5, new int[][]{{0, 1}, {0, 2}, {3, 4}, {2, 3}}));
    }


}
