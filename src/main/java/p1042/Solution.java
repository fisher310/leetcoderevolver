package p1042;

import java.util.*;

class Solution {

    public int[] gardenNoAdj(int N, int[][] paths) {

        Map<Integer, List<Integer>> graph = new HashMap<>();

        // 准备邻接表
        for (int[] edge : paths) {
            if (!graph.containsKey(edge[0])) {
                graph.put(edge[0], new ArrayList<>());
            }
            graph.get(edge[0]).add(edge[1]);
            if (!graph.containsKey(edge[1])) {
                graph.put(edge[1], new ArrayList<>());
            }
            graph.get(edge[1]).add(edge[0]);
        }

        int[] ans = new int[N];

        for (int i = 0; i < N; i++) {
            Set<Integer> colors =
                    new HashSet<>() {
                        {
                            add(1);
                            add(2);
                            add(3);
                            add(4);
                        }
                    };

            List<Integer> adj = graph.getOrDefault(i + 1, new ArrayList<>());
            for (int c : adj) {
                colors.remove(ans[c - 1]);
            }
            ans[i] = colors.iterator().next();
        }

        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.gardenNoAdj(3, new int[][] {{1, 2}, {2, 3}, {3, 1}})));
        System.out.println(Arrays.toString(s.gardenNoAdj(4, new int[][] {{1, 2}, {3, 4}})));
        System.out.println(
                Arrays.toString(
                        s.gardenNoAdj(
                                4, new int[][] {{1, 2}, {2, 3}, {3, 4}, {4, 1}, {1, 3}, {2, 4}})));
    }
}
