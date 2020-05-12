package p1020;

import java.util.Arrays;

class Solution {
    private int row;
    private int col;

    private int[] dx = { 1, 0, -1, 0 };
    private int[] dy = { 0, -1, 0, 1 };

    public int numEnclaves(int[][] A) {
        if (A == null || A.length == 0)
            return 0;
        row = A.length;
        col = A[0].length;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if ((i == 0 || j == 0 || i == row - 1 || j == col - 1) && A[i][j] == 1) {
                    dfs(A, i, j);
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (A[i][j] == 1) {
                    ans++;
                }
            }
        }

        return ans;
    }

    private void dfs(int[][] matrix, int i, int j) {
        matrix[i][j] = 2;
        for (int k = 0; k < 4; k++) {
            int cx = i + dx[k];
            int cy = j + dy[k];
            if (cx >= 0 && cx < row && cy >= 0 && cy < col && matrix[cx][cy] == 1) {
                dfs(matrix, cx, cy);
            }
        }
    }

    private void print(int[][] matrix) {
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println("=====================================");

    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] matrix2 = new int[][] { { 0, 0, 0, 1, 1, 1, 0, 1, 0, 0 }, { 1, 1, 0, 0, 0, 1, 0, 1, 1, 1 },
                { 0, 0, 0, 1, 1, 1, 0, 1, 0, 0 }, { 0, 1, 1, 0, 0, 0, 1, 0, 1, 0 }, { 0, 1, 1, 1, 1, 1, 0, 0, 1, 0 },
                { 0, 0, 1, 0, 1, 1, 1, 1, 0, 1 }, { 0, 1, 1, 0, 0, 0, 1, 1, 1, 1 }, { 0, 0, 1, 0, 0, 1, 0, 1, 0, 1 },
                { 1, 0, 1, 0, 1, 1, 0, 0, 0, 0 }, { 0, 0, 0, 0, 1, 1, 0, 0, 0, 1 } };

        int ans2 = s.numEnclaves(matrix2);
        System.out.println(ans2); // expected is 3

        int[][] matrix1 = new int[][] { { 0, 0, 0, 0 }, { 1, 0, 1, 0 }, { 0, 1, 1, 0 }, { 0, 0, 0, 0 } };

        int ans = s.numEnclaves(matrix1);
        System.out.println(ans);

    }
}