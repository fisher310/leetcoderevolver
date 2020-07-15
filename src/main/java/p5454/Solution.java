package p5454;

class Solution {

    /**
     * 向右边和下边搜索
     *
     * @param mat
     * @return
     */
    int row;

    int col;
    int res = 0;

    public int numSubmat(int[][] mat) {
        if (mat == null || mat.length == 0) return 0;
        row = mat.length;
        col = mat[0].length;
        res = 0;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (mat[i][j] == 1) {
                    res += 1;
                    dfs(mat, i, j);
                }
            }
        }

        return res;
    }

    void dfs(int[][] mat, int r, int c) {

        // 向下边走
        int maxR = r;
        for (int i = r + 1; i < row; i++) {
            if (mat[i][c] == 1) {
                res += 1;
                maxR = i;
            } else {
                break;
            }
        }

        int maxC = c;
        for (int j = c + 1; j < col; j++) {
            if (mat[r][j] == 1) {
                res += 1;
                maxC = j;
            } else {
                break;
            }
        }

        for (int i = r + 1; i <= maxR; i++) {
            outer:
            for (int j = c + 1; j <= maxC; j++) {
                if (mat[i][j] == 1) {
                    // fixed row = i, fixed col = j, r -> i all 1, c -> j -> all 1
                    for (int ii = r + 1; ii <= i; ii++) {
                        for (int jj = c + 1; jj <= j; jj++) {
                            if (mat[ii][jj] == 0) {
                                continue outer;
                            }
                        }
                    }

                    res += 1;
//                    System.out.println(r + ", " + c + ", " + i + "," + j);
                }
            }
        }

        //        System.out.println("point (" + r + "," + c + ") = " + res);
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(
                s.numSubmat(
                        new int[][] {
                            {1, 1, 1},
                            {1, 0, 1},
                            {1, 1, 1}
                        }));

        System.out.println(
                s.numSubmat(
                        new int[][] {
                            {0, 0, 1, 1, 1, 1, 1},
                            {1, 1, 1, 0, 0, 1, 0},
                            {1, 1, 0, 1, 0, 0, 1},
                            {0, 1, 1, 1, 1, 1, 1},
                            {0, 1, 1, 0, 1, 0, 0},
                            {0, 1, 0, 0, 1, 0, 0},
                            {1, 1, 1, 1, 1, 0, 1},
                            {1, 1, 1, 0, 0, 0, 1},
                            {1, 0, 1, 1, 1, 1, 0}
                        }));
        //        System.out.println(s.numSubmat(new int[][] {{1, 0, 1}, {1, 1, 0}, {1, 1, 1}}));
        //        System.out.println(s.numSubmat(new int[][] {{0, 1, 1, 0}, {0, 1, 1, 1}, {1, 1, 1,
        // 0}}));
    }
}
