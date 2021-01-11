package p289;

/**
 * @author lihailong
 * @since 2021/1/9 0009
 */
class Solution {

    private final int[] dx = new int[] {1, 0, -1, 0, 1, -1, 1, -1};
    private final int[] dy = new int[] {0, 1, 0, -1, 1, -1, -1, 1};

    private int C;
    private int R;

    public void gameOfLife(int[][] board) {
        this.R = board.length;
        this.C = board[0].length;

        int[][] copy = new int[R][C];

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                copy[i][j] = board[i][j];
            }
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                board[i][j] = resolve(copy, i, j);
            }
        }
    }

    private int resolve(int[][] board, int i, int j) {

        int live = 0;
        for (int k = 0; k < 8; k++) {
            int x = i + dx[k];
            int y = j + dy[k];
            if (x >= 0 && x < R && y >= 0 && y < C && board[x][y] == 1) {
                live++;
            }
        }
        if (board[i][j] == 1) {
            if (live < 2 || live > 3) {
                return 0;
            } else {
                return 1;
            }
        } else {
            if (live == 3) {
                return 1;
            }
        }
        return 0;
    }
}
