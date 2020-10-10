package p1594;

import org.junit.Assert;

class Solution {

    public int maxProductPath(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        long[][][] dp = new long[row][col][2];

        dp[0][0][1] = grid[0][0];
        dp[0][0][0] = grid[0][0];
        for (int i = 1; i < row; i++) {
            dp[i][0][1] = dp[i - 1][0][1] * grid[i][0];
            dp[i][0][0] = dp[i - 1][0][0] * grid[i][0];
        }

        for (int j = 1; j < col; j++) {
            dp[0][j][0] = dp[0][j - 1][0] * grid[0][j];
            dp[0][j][1] = dp[0][j - 1][1] * grid[0][j];
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                dp[i][j][1] =
                        max(
                                dp[i - 1][j][0] * grid[i][j],
                                dp[i - 1][j][1] * grid[i][j],
                                dp[i][j - 1][0] * grid[i][j],
                                dp[i][j - 1][1] * grid[i][j]);
                dp[i][j][0] =
                        min(
                                dp[i - 1][j][0] * grid[i][j],
                                dp[i - 1][j][1] * grid[i][j],
                                dp[i][j - 1][0] * grid[i][j],
                                dp[i][j - 1][1] * grid[i][j]);
                //                print(dp);
            }
        }

        if (dp[row - 1][col - 1][1] < 0) return -1;
        return (int) (dp[row - 1][col - 1][1] % (1000000007));
    }

    private long max(long... arr) {
        long max = Long.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }
        return max;
    }

    private long min(long... arr) {
        long max = Long.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max = Math.min(max, arr[i]);
        }
        return max;
    }

    private void print(long[][][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print("(" + arr[i][j][0] + "," + arr[i][j][1] + ") \t");
            }
            System.out.println();
        }
        System.out.println("==============================");
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        Assert.assertEquals(
                2, s.maxProductPath(new int[][] {{1, 4, 4, 0}, {-2, 0, 0, 1}, {1, -1, 1, 1}}));
    }
}
