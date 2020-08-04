package p766;

import org.junit.Assert;

class Solution {

    public boolean isToeplitzMatrix(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int x = i, y = j;
                while (x < row - 1 && y < col - 1) {
                    if (matrix[x][y] != matrix[x + 1][y + 1]) {
                        return false;
                    }
                    x++;
                    y++;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        Assert.assertTrue(
                s.isToeplitzMatrix(new int[][] {{1, 2, 3, 4}, {5, 1, 2, 3}, {9, 5, 1, 2}}));
        Assert.assertFalse(s.isToeplitzMatrix(new int[][] {{1, 2}, {2, 2}}));
    }
}
