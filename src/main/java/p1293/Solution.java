package p1293;

import org.junit.Assert;

import java.util.LinkedList;
import java.util.Queue;

class Solution {

    private int[] dx = {1, 0, -1, 0};
    private int[] dy = {0, 1, 0, -1};

    public int shortestPath(int[][] grid, int k) {
        int row = grid.length;
        int col = grid[0].length;
        if (row == 1 && col == 1) {
            return 0;
        }
        k = Math.min(k, row + col - 3);

        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(0, 0, k));
        int step = 0;
        boolean[][][] visited = new boolean[row][col][k + 1];
        visited[0][0][k] = true;
        while (!queue.isEmpty()) {
            step++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node point = queue.poll();
                for (int j = 0; j < 4; j++) {
                    int x = point.x + dx[j];
                    int y = point.y + dy[j];
                    if (x == row - 1 && y == col - 1) return step;
                    if (x >= 0 && x < row && y >= 0 && y < col) {
                        if (grid[x][y] == 0 && !visited[x][y][point.rest]) {
                            if (x == row - 1 && y == col - 1) return step;
                            queue.offer(new Node(x, y, point.rest));
                            visited[x][y][point.rest] = true;
                        } else if (grid[x][y] == 1 && point.rest > 0 && !visited[x][y][point.rest-1]) {
                            queue.offer(new Node(x, y, point.rest - 1));
                            visited[x][y][point.rest - 1] = true;
                        }
                    }

                }
            }
        }
        return -1;
    }

    private class Node {
        int x, y, rest;

        private Node(int x, int y, int rest) {
            this.x = x;
            this.y = y;
            this.rest = rest;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        Assert.assertEquals(24, s.shortestPath(
                new int[][]{
                        {0, 0, 1, 0, 0, 0, 0, 1, 0, 1, 1, 0, 0, 1, 1},
                        {0, 0, 0, 1, 1, 0, 0, 1, 1, 0, 1, 0, 0, 0, 1},
                        {1, 1, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 1, 0, 0},
                        {1, 0, 1, 1, 1, 1, 0, 0, 1, 1, 0, 1, 0, 0, 1},
                        {1, 0, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1, 1, 1},
                        {0, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 1, 1, 1, 1},
                        {0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 1, 1, 0, 1, 1},
                        {1, 0, 0, 1, 1, 1, 1, 1, 1, 0, 0, 0, 1, 1, 0},
                        {0, 0, 1, 0, 0, 1, 1, 1, 1, 1, 0, 1, 0, 0, 0},
                        {0, 0, 0, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 0, 0},
                        {0, 0, 0, 0, 1, 1, 1, 0, 0, 1, 1, 1, 0, 1, 0}
                },
                27
        ));
        Assert.assertEquals(-1,
                s.shortestPath(new int[][]{{0, 1, 1}, {1, 1, 1}, {1, 0, 0}}, 1));
        Assert.assertEquals(6, s.shortestPath(
                new int[][]{{0, 0, 0}, {1, 1, 0}, {0, 0, 0}, {0, 1, 1}, {0, 0, 0}}, 1));
    }

}
