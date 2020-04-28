package p74;

import org.junit.Assert;

/** 搜索二维矩阵 */
class Solution {

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) return false;

        int row = matrix.length;
        int col = matrix[0].length;

        int lo = 0, hi = row;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (matrix[mid][0] > target) {
                hi = mid;
            } else if (matrix[mid][col - 1] < target) {
                lo = mid + 1;
            } else {
                int[] search = matrix[mid];
                int l = 0, r = col;
                while (l < r) {
                    int m = l + (r - l) / 2;
                    if (search[m] == target) {
                        return true;
                    } else if (search[m] < target) {
                        l = m + 1;
                    } else {
                        r = m;
                    }
                }
                return false;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        Assert.assertTrue(
                s.searchMatrix(new int[][] {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 50}}, 3));

        Assert.assertFalse(
                s.searchMatrix(new int[][] {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 50}}, 13));
    }
}
