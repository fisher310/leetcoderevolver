package p840;

/**
 * 3 x 3 的幻方是一个填充有从 1 到 9 的不同数字的 3 x 3 矩阵，其中每行，每列以及两条对角线上的各数之和都相等。
 *
 * <p>给定一个由整数组成的 grid，其中有多少个 3 × 3 的 “幻方” 子矩阵？（每个子矩阵都是连续的）。
 *
 * @author lihailong
 * @since 2021/1/14 0014
 */
class Solution {

    public int numMagicSquaresInside(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        if (row < 3 || col < 3) return 0;

        int ans = 0;
        for (int i = 0; i <= row - 3; i++) {
            for (int j = 0; j <= col - 3; j++) {
                ans += check(grid, i, j);
            }
        }

        return ans;
    }

    private int check(int[][] grid, int i, int j) {
        int sr = grid[i][j] + grid[i][j + 1] + grid[i][j + 2];
        if (sr != 15) return 0;
        int sc = grid[i][j] + grid[i + 1][j] + grid[i + 2][j];
        if (sc != 15) return 0;
        int sn = grid[i][j] + grid[i + 1][j + 1] + grid[i + 2][j + 2];
        if (sn != 15) return 0;
        int sp = grid[i][j + 2] + grid[i + 1][j + 1] + grid[i + 2][j];
        if (sp != 15) return 0;

        boolean[] arr = new boolean[10];
        for (int r = i; r < i + 3; r++) {
            for (int c = j; c < j + 3; c++) {
                if (grid[r][c] > 9 || grid[r][c] < 1) return 0;
                if (arr[grid[r][c]]) return 0;
                arr[grid[r][c]] = true;
            }
        }

        return 1;
    }
}
