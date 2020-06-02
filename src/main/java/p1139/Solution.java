package p1139;

/** 最大的以 1 为边界的正方形 */
class Solution {
    int ans;
    int row, col;

    public int largest1BorderedSquare(int[][] grid) {
        if (grid == null || grid[0].length == 0) return 0;
        row = grid.length;
        col = grid[0].length;

        ans = 0;

        for (int i = 0; i < row; i++) {

            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    dfs(grid, i, j);
                }
            }
        }
        return ans;
    }

    private void dfs(int[][] grid, int r, int c) {
        ans = Math.max(ans, 1);
        int sr = r;
        int sc = c;
        while (r < row-1 && c-1 < col) {
            if (grid[r+1][c] == 1 && grid[r][c+1] == 1) {
                continue;
            } else {

            }
        }
        ans = Math.max((r - sr + 1) * (c - sc + 1), ans);
    }
}
