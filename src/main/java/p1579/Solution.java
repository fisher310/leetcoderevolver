package p1579;

import org.junit.Assert;

import java.util.Arrays;

/**
 * 输入：n = 4, edges = [[3,1,2],[3,2,3],[1,1,3],[1,2,4],[1,1,2],[2,3,4]] <br>
 * 输出：2
 */
class Solution {

    public int maxNumEdgesToRemove(int n, int[][] edges) {

        Arrays.sort(edges, (o1, o2) -> Integer.compare(o2[0], o1[0]));

        UFD ufd1 = new UFD(n);
        UFD ufd2 = new UFD(n);
        int ans = 0;
        for (int[] edge : edges) {
            if (edge[0] == 3) {
                if (ufd1.connected(edge[1], edge[2])) {
                    ans++;
                } else {
                    ufd1.union(edge[1], edge[2]);
                    ufd2.union(edge[1], edge[2]);
                }
            } else if (edge[0] == 1) {
                if (ufd1.connected(edge[1], edge[2])) {
                    ans++;
                } else {
                    ufd1.union(edge[1], edge[2]);
                }
            } else if (edge[0] == 2) {
                if (ufd2.connected(edge[1], edge[2])) {
                    ans++;
                } else {
                    ufd2.union(edge[1], edge[2]);
                }
            }
        }

        return ufd1.count == 1 && ufd2.count == 1 ? ans : -1;
    }

    class UFD {

        int[] tree;
        int count;
        UFD(int count) {
            this.count = count;
            tree = new int[this.count + 1];
            for (int i = 1; i <= count; i++) {
                tree[i] = i;
            }
        }

        void union(int i, int j) {
            int pi = find(i);
            int pj = find(j);
            if (pi != pj) {
                tree[pi] = pj;
                count--;
            }
        }

        boolean connected(int i, int j) {
            return find(i) == find(j);
        }

        int find(int j) {
            int p = tree[j];
            if (p != j) {
                tree[j] = find(p);
            }
            return tree[j];
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        Assert.assertEquals(
                2,
                s.maxNumEdgesToRemove(
                        4,
                        new int[][] {
                            {3, 1, 2}, {3, 2, 3}, {1, 1, 3}, {1, 2, 4}, {1, 1, 2}, {2, 3, 4}
                        }));
        Assert.assertEquals(
                0,
                s.maxNumEdgesToRemove(4, new int[][] {{3, 1, 2}, {3, 2, 3}, {1, 1, 4}, {2, 1, 4}}));
        Assert.assertEquals(
                -1, s.maxNumEdgesToRemove(4, new int[][] {{3, 2, 3}, {1, 1, 2}, {2, 3, 4}}));
    }
}
