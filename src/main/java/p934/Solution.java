package p934;

import org.junit.Assert;

import java.util.LinkedList;
import java.util.Queue;

class Solution {

    private final int[] dx = {1, 0, -1, 0};
    private final int[] dy = {0, 1, 0, -1};

    private int row;
    private int col;

    public int shortestBridge(int[][] A) {
        row = A.length;
        col = A[0].length;

        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (A[i][j] == 1) {
                    dfs(A, i, j, queue);
                    return bfs(A, queue);
                }
            }
        }
        return -1;
    }

    private int bfs(int[][] A, Queue<int[]> queue) {
        int step = 0;
        while (!queue.isEmpty()) {
            step++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                for (int k = 0; k < 4; k++) {
                    int x = curr[0] + dx[k];
                    int y = curr[1] + dy[k];
                    if (x >= 0 && x < row && y >= 0 && y < row && A[x][y] != 2) {
                        if (A[x][y] == 1) return step - 1;
                        A[x][y] = 2;
                        queue.offer(new int[]{x, y});
                    }
                }
            }
        }
        return -1;
    }

    private void dfs(int[][] grid, int a, int b, Queue<int[]> queue) {
        grid[a][b] = 2;
        queue.offer(new int[]{a, b});
        for (int i = 0; i < 4; i++) {
            int x = a + dx[i];
            int y = b + dy[i];
            if (x >= 0 && x < row && y >= 0 && y < col) {
                if (grid[x][y] == 1) {
                    dfs(grid, x, y, queue);
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        Assert.assertEquals(2, s.shortestBridge(new int[][]{{0, 1, 0}, {0, 0, 0}, {0, 0, 1}}));
        Assert.assertEquals(1,
                s.shortestBridge(
                        new int[][]{
                                {1, 1, 1, 1, 1},
                                {1, 0, 0, 0, 1},
                                {1, 0, 1, 0, 1},
                                {1, 0, 0, 0, 1},
                                {1, 1, 1, 1, 1}
                        }));
    }
}
