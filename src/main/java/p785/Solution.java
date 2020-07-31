package p785;

import org.junit.Assert;

import java.util.LinkedList;
import java.util.Queue;

class Solution {

    private static final int GREEN = 1;
    private static final int RED = 2;

    public boolean isBipartite(int[][] graph) {

        int[] color = new int[graph.length];

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < color.length; i++) {
            if (color[i] == 0) {
                // bfs
                color[i] = GREEN;
                queue.offer(i);
                while (!queue.isEmpty()) {
                    int curr = queue.poll();
                    int otherColor = color[curr] == GREEN ? RED : GREEN;
                    for (int j : graph[curr]) {
                        if (color[j] == 0) {
                            color[j] = otherColor;
                            queue.offer(j);
                        } else if (color[j] != otherColor) {
                            return false;
                        }
                    }
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.isBipartite(new int[][] {{1, 2, 3}, {0, 2}, {0, 1, 3}, {0, 2}}));
        System.out.println(s.isBipartite(new int[][] {{1, 3}, {0, 2}, {1, 3}, {0, 2}}));
        Assert.assertTrue(s.isBipartite(new int[][] {{1}, {0, 3}, {3}, {1, 2}}));
        Assert.assertFalse(
                s.isBipartite(
                        new int[][] {
                            {},
                            {2, 4, 6},
                            {1, 4, 8, 9},
                            {7, 8},
                            {1, 2, 8, 9},
                            {6, 9},
                            {1, 5, 7, 8, 9},
                            {3, 6, 9},
                            {2, 3, 4, 6, 9},
                            {2, 4, 5, 6, 7, 8}
                        }));
    }
}
