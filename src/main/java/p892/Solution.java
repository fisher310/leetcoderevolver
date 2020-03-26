package p892;

class Solution {
    public int surfaceArea(int[][] grid) {

        int area = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                int v = grid[i][j];
                if (v > 0) {
                    area += v * 4 + 2;
                    if (j < grid[0].length - 1) {
                        int right = Math.min(v, grid[i][j + 1]);
                        area -= right * 2;
                    }
                    if (i < grid.length - 1) {
                        int left = Math.min(v, grid[i + 1][j]);
                        area -= left * 2;
                    }
                }
            }
        }
        return area;
    }
}
