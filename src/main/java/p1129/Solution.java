package p1129;

import org.junit.Assert;

import java.util.*;

class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] red_edges, int[][] blue_edges) {

        Map<Integer, List<Integer>> redGraph = new HashMap<>();
        Map<Integer, List<Integer>> blueGraph = new HashMap<>();
        for (int[] edge : red_edges) {
            redGraph.computeIfAbsent(edge[0], s -> new ArrayList<>());
            redGraph.get(edge[0]).add(edge[1]);
        }
        for (int[] edge : blue_edges) {
            blueGraph.computeIfAbsent(edge[0], s -> new ArrayList<>());
            blueGraph.get(edge[0]).add(edge[1]);
        }

        Set<Integer> redSet = new HashSet<>();
        redSet.add(0);

        Set<Integer> blueSet = new HashSet<>();
        blueSet.add(0);
        boolean[][] redVisited = new boolean[n][n];
        boolean[][] blueVisited = new boolean[n][n];

        int step = 0;
        // [][0] red , [][1] blue
        Integer[][] res = new Integer[n][2];
        res[0][0] = 0;
        res[0][1] = 0;

        while (!redSet.isEmpty() || !blueSet.isEmpty()) {
            step++;
            Set<Integer> newRedSet = new HashSet<>();
            Set<Integer> newBlueSet = new HashSet<>();
            for (int r : redSet) {
                for (int nextBlue : blueGraph.getOrDefault(r, Collections.emptyList())) {
                    if (!blueVisited[r][nextBlue]) {
                        newBlueSet.add(nextBlue);
                        blueVisited[r][nextBlue] = true;
                        if (res[nextBlue][1] == null) {
                            res[nextBlue][1] = step;
                        }
                    }
                }
            }

            for (int b : blueSet) {
                for (int nextRed : redGraph.getOrDefault(b, Collections.emptyList())) {
                    if (!redVisited[b][nextRed]) {
                        newRedSet.add(nextRed);
                        redVisited[b][nextRed] = true;
                        if (res[nextRed][0] == null) {
                            res[nextRed][0] = step;
                        }
                    }
                }
            }

            redSet = newRedSet;
            blueSet = newBlueSet;
        }

        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int value = -1;
            if (res[i][0] != null && res[i][1] != null) {
                value = Math.min(res[i][0], res[i][1]);
            } else if (res[i][0] != null) {
                value = res[i][0];
            } else if (res[i][1] != null) {
                value = res[i][1];
            }
            ans[i] = value;
        }

        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        Assert.assertArrayEquals(
                new int[] {0, 1, 1},
                s.shortestAlternatingPaths(3, new int[][] {{0, 1}, {0, 2}}, new int[][] {{1, 0}}));
        Assert.assertArrayEquals(
                new int[] {0, 1, 2, 3, 7},
                s.shortestAlternatingPaths(
                        5,
                        new int[][] {{0, 1}, {1, 2}, {2, 3}, {3, 4}},
                        new int[][] {{1, 2}, {2, 3}, {3, 1}}));
        Assert.assertArrayEquals(
                new int[] {0, 1, -1},
                s.shortestAlternatingPaths(3, new int[][] {{0, 1}, {1, 2}}, new int[][] {}));
        Assert.assertArrayEquals(
                new int[] {0, 1, 2},
                s.shortestAlternatingPaths(3, new int[][] {{0, 1}}, new int[][] {{1, 2}}));
    }
}
