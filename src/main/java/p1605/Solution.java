package p1605;

class Solution {

    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int row = rowSum.length;
        int col = colSum.length;
        int[][] res = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int min = Math.min(rowSum[i], colSum[j]);
                res[i][j] = min;
                rowSum[i] -= min;
                colSum[j] -= min;
            }
        }
        return res;
    }
}
