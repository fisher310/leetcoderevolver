package p378;

import org.junit.Assert;

/** 有序矩阵中第K小的元素 */
class Solution {

    public int kthSmallest(int[][] matrix, int k) {

        int n = matrix.length;

        int l = matrix[0][0];
        int r = matrix[n - 1][n - 1];

        while (l < r) {
            int mid = l + (r - l) / 2;

            if (isLeftUp(matrix, mid, k, n)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }

        return l;
    }

    private boolean isLeftUp(int[][] matrix, int mid, int k, int n) {
        int j = 0;
        int i = n - 1;

        int num = 0;
        while (i >= 0 && j < n) {
            if (matrix[i][j] <= mid) {
                num += i + 1;
                j++;
            } else {
                i--;
            }
        }
        return num >= k;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        Assert.assertEquals(
                13, s.kthSmallest(new int[][] {{1, 5, 9}, {10, 11, 13}, {12, 13, 15}}, 8));

        System.out.println(
                s.kthSmallest(
                        new int[][] {
                            {1, 3, 5, 7, 9, 11},
                            {2, 4, 6, 8, 10, 12},
                            {3, 5, 7, 9, 11, 13},
                            {4, 6, 8, 10, 12, 14},
                            {5, 7, 9, 11, 13, 15},
                            {6, 8, 10, 12, 14, 16}
                        },
                        8));
    }
}
