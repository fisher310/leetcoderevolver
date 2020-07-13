package p240;

class Solution {

    public boolean searchMatrix(int[][] matrix, int target) {
        if (null == matrix || matrix.length == 0) return false;

        int row = matrix.length - 1;
        int col = 0;
        while (row >= 0 && col <= matrix[0].length - 1) {
            if (matrix[row][col] > target) {
                row--;
            } else if (matrix[row][col] < target) {
                col++;
            } else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.searchMatrix(new int[][] {{-5}}, -2));
        int[][] matrix =
                new int[][] {
                    {1, 4, 7, 11, 15},
                    {2, 5, 8, 12, 19},
                    {3, 6, 9, 16, 22},
                    {10, 13, 14, 17, 24},
                    {18, 21, 23, 26, 30}
                };
        System.out.println(s.searchMatrix(matrix, 19));
    }
}
