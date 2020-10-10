package p329;

import org.junit.Assert;

class Solution {

    int[] dx = {1, 0, -1, 0};
    int[] dy = {0, 1, 0, -1};
    int row;
    int col;
    int max;
    int[][] cache;

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;
        row = matrix.length;
        col = matrix[0].length;
        max = 0;
        cache = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                max = Math.max(max, dfs(matrix, i, j));
            }
        }

        return max;
    }

    int dfs(int[][] matrix, int r, int c) {
        if (cache[r][c] != 0) {
            return cache[r][c];
        }
        int curr = 1;
        for (int k = 0; k < 4; k++) {
            int dr = r + dx[k];
            int dc = c + dy[k];
            if (dr >= 0 && dr < row && dc >= 0 && dc < col && matrix[dr][dc] < matrix[r][c]) {
                int x = dfs(matrix, dr, dc);
                curr = Math.max(curr, x + 1);
            }
        }
        cache[r][c] = curr;
        return curr;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        Assert.assertEquals(4,
                s.longestIncreasingPath(new int[][]{{9, 9, 4}, {6, 6, 8}, {2, 1, 1}}));
        Assert.assertEquals(4,
                s.longestIncreasingPath(new int[][]{{3, 4, 5}, {3, 2, 6}, {2, 2, 1}}));
        Assert.assertEquals(140,
                s.longestIncreasingPath(new int[][]{
                        {0, 1, 2, 3, 4, 5, 6, 7, 8, 9},
                        {19, 18, 17, 16, 15, 14, 13, 12, 11, 10},
                        {20, 21, 22, 23, 24, 25, 26, 27, 28, 29},
                        {39, 38, 37, 36, 35, 34, 33, 32, 31, 30},
                        {40, 41, 42, 43, 44, 45, 46, 47, 48, 49},
                        {59, 58, 57, 56, 55, 54, 53, 52, 51, 50},
                        {60, 61, 62, 63, 64, 65, 66, 67, 68, 69},
                        {79, 78, 77, 76, 75, 74, 73, 72, 71, 70},
                        {80, 81, 82, 83, 84, 85, 86, 87, 88, 89},
                        {99, 98, 97, 96, 95, 94, 93, 92, 91, 90},
                        {100, 101, 102, 103, 104, 105, 106, 107, 108, 109},
                        {119, 118, 117, 116, 115, 114, 113, 112, 111, 110},
                        {120, 121, 122, 123, 124, 125, 126, 127, 128, 129},
                        {139, 138, 137, 136, 135, 134, 133, 132, 131, 130},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}}));
    }
}
