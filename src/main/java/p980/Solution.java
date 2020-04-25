package p980;

import java.util.Arrays;

/** 不同路径 III */
class Solution {

    private int row;
    private int col;
    private int ans;
    private int[] dx = {1, 0, -1, 0};
    private int[] dy = {0, 1, 0, -1};

    public int uniquePathsIII(int[][] grid) {
        if (null == grid || grid.length == 0) return 0;

        row = grid.length;
        col = grid[0].length;
        ans = 0;

        boolean[][] visited = new boolean[row][col];

        int si = 0, sj = 0, total = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    si = i;
                    sj = j;
                } else if (grid[i][j] == 0) {
                    total++;
                }
            }
        }
        visited[si][sj] = true;
        dfs(grid, si, sj, visited, total, 0);

        return ans;
    }

    void dfs(int[][] grid, int i, int j, boolean[][] visited, int total, int count) {

        for (int k = 0; k < 4; k++) {
            int x = i + dx[k];
            int y = j + dy[k];
            if (x >= 0 && x < row && y >= 0 && y < col && !visited[x][y]) {
                if (grid[x][y] == 0) {
                    visited[x][y] = true;
                    dfs(grid, x, y, visited, total, count + 1);
                    visited[x][y] = false;
                } else if (grid[x][y] == 2) {
                    //                    print(visited);
                    if (count == total) {
                        ans++;
                    }
                }
            }
        }
    }

    void print(boolean[][] visited) {
        for (boolean[] row : visited) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println("-----------------------------");
    }
}
