package p1162;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    // → ↓ ← ↑
    private int[] x = new int[]{1, 0, -1, 0};
    private int[] y = new int[]{0, 1, 0, -1};

    public int maxDistance(int[][] grid) {

        int len = grid.length;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (grid[i][j] == 1) {
                    queue.offer(new int[]{i, j});
                }
            }
        }

        boolean hasOcean = false;
        int point[] = null;

        while (!queue.isEmpty()) {
            point = queue.poll();
            int px = point[0], py = point[1];
            for (int i = 0; i < 4; i++) {
                int xi = px + x[i];
                int yi = py + y[i];

                if (xi < 0 || xi >= len || yi < 0 || yi >= len || grid[xi][yi] != 0) continue;

                hasOcean = true;
                grid[xi][yi] = grid[px][py] + 1;
                queue.offer(new int[]{xi, yi});
            }

        }

        if (point == null || !hasOcean) return -1;

        return grid[point[0]][point[1]] - 1;
    }

}
