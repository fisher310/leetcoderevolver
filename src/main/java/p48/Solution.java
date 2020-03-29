package p48;

import java.util.Arrays;

class Solution {
    public void rotate(int[][] matrix) {
        if (null == matrix || matrix.length == 0) return;

        int startRow = 0;
        int startCol = 0;
        int endRow = matrix.length - 1;
        int endCol = matrix[0].length - 1;

        while (startRow < endRow) {
            helper(matrix, startRow, startCol, endRow, endCol);
            startRow++;
            endRow--;
            startCol++;
            endCol--;
        }
    }

    void helper(int[][] matrix, int startRow, int startCol, int endRow, int endCol) {
        int time = endRow - startRow;
        for (int i = 0; i < time; i++) {
            int temp = matrix[startRow][startCol + i];
            matrix[startRow][startCol + i] = matrix[endRow - i][startCol];
            matrix[endRow - i][startCol] = matrix[endRow][endCol - i];
            matrix[endRow][endCol - i] = matrix[startRow + i][endCol];
            matrix[startRow + i][endCol] = temp;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] matrix = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        s.rotate(matrix);
        for (int[] r : matrix) {
            System.out.println(Arrays.toString(r));
        }

        System.out.println("+============================");
        matrix = new int[][]{{5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}};
        s.rotate(matrix);
        for (int[] r : matrix) {
            System.out.println(Arrays.toString(r));
        }
    }
}
