package p1559;

import org.junit.Assert;

class Solution {

    private final int[] dx = {1, 0, -1, 0};
    private final int[] dy = {0, 1, 0, -1};
    private int row;
    private int col;

    public boolean containsCycle(char[][] grid) {
        if (null == grid || grid.length == 0) return false;

        row = grid.length;
        col = grid[0].length;

        boolean[][] visited = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (!visited[i][j]) {
                    visited[i][j] = true;
                    if (dfs(grid, grid[i][j], i, j, -1, -1, visited)) return true;
                }
            }
        }

        return false;
    }

    private boolean dfs(
            char[][] grid, char c, int ci, int cj, int li, int lj, boolean[][] visited) {
        for (int k = 0; k < 4; k++) {
            int x = ci + dx[k];
            int y = cj + dy[k];

            if (x >= 0 && x < row && y >= 0 && y < col && (li != x || lj != y) && grid[x][y] == c) {
                if (visited[x][y]) return true;

                visited[x][y] = true;
                if (dfs(grid, c, x, y, ci, cj, visited)) {
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        Assert.assertFalse(
                s.containsCycle(
                        new char[][] {
                            {'b', 'a', 'c'}, {'c', 'a', 'c'}, {'d', 'd', 'c'}, {'b', 'c', 'c'}
                        }));
        Assert.assertFalse(
                s.containsCycle(new char[][] {{'a', 'b', 'b'}, {'b', 'z', 'b'}, {'b', 'b', 'a'}}));
        Assert.assertTrue(
                s.containsCycle(
                        new char[][] {
                            {'a', 'a', 'a', 'a'},
                            {'a', 'b', 'b', 'a'},
                            {'a', 'b', 'b', 'a'},
                            {'a', 'a', 'a', 'a'}
                        }));
        Assert.assertTrue(
                s.containsCycle(
                        new char[][] {
                            {'c', 'c', 'c', 'a'},
                            {'c', 'd', 'c', 'c'},
                            {'c', 'c', 'e', 'c'},
                            {'f', 'c', 'c', 'c'}
                        }));
    }
}
