package p310;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 最小高度树
 */
class Solution {

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {

        if (n == 1) return List.of(0);

        int[] degree = new int[n];
        List<List<Integer>> graph = new ArrayList<>(n);

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            degree[edge[0]]++;
            degree[edge[1]]++;
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        List<Integer> ans = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (degree[i] == 1) queue.offer(i);
        }
        while (!queue.isEmpty()) {
            ans = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int node = queue.poll();
                ans.add(node);
                for (int child : graph.get(node)) {
                    degree[child] --;
                    if (degree[child] == 1) {
                        queue.offer(child);
                    }
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.findMinHeightTrees(4, new int[][] {{1, 0}, {1, 2}, {1, 3}}));
        System.out.println(
                s.findMinHeightTrees(6, new int[][] {{0, 3}, {1, 3}, {2, 3}, {4, 3}, {5, 4}}));
    }
}
