package p1519;

import org.junit.Assert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 1. labels[i]  i 节点标签
 * 2. edges[i] 边
 * 3. ans[i] i 子树与i 标签相同的数字
 */
class Solution {

    int[] ans;

    public int[] countSubTrees(int n, int[][] edges, String labels) {
        Map<Integer, List<Integer>> tree = new HashMap<>();
        ans = new int[n];

        for (int[] edge : edges) {
            build(tree, edge[0], edge[1]);
            build(tree, edge[1], edge[0]);
        }

        boolean[] visited = new boolean[n];
        dfs(tree, 0, labels, visited);

        return ans;
    }

    private void build(Map<Integer, List<Integer>> tree, int a, int b) {
        if (tree.containsKey(a)) {
            tree.get(a).add(b);
        } else {
            List<Integer> children = new ArrayList<>();
            children.add(b);
            tree.put(a, children);
        }
    }

    private int[] dfs(Map<Integer, List<Integer>> tree, int n, String labels, boolean[] visited) {
        visited[n] = true;
        List<Integer> children = tree.get(n);
        int[] res = new int[26];
        if (children != null) {
            for (int child : children) {
                if (!visited[child]) {
                    int[] r = dfs(tree, child, labels, visited);
                    for (int i = 0; i < 26; i++) {
                        res[i] += r[i];
                    }
                }
            }
        }
        char c = labels.charAt(n);
        res[c - 'a']++;
        ans[n] = res[c - 'a'];
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        Assert.assertArrayEquals(new int[]{1, 1, 2, 1}, s.countSubTrees(4, new int[][]{{0, 2}, {0, 3}, {1, 2}}, "aeed"));
        Assert.assertArrayEquals(new int[]{2, 1, 1, 1, 1, 1, 1}, s.countSubTrees(7, new int[][]{{0, 1}, {0, 2}, {1, 4}, {1, 5}, {2, 3}, {2, 6}}, "abaedcd"));
        Assert.assertArrayEquals(new int[]{4, 2, 1, 1}, s.countSubTrees(4, new int[][]{{0, 1}, {1, 2}, {0, 3}}, "bbbb"));

    }
}
