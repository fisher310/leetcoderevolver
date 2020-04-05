package p130;

import java.util.LinkedList;
import java.util.Queue;

/** 被围绕的区域 */
class Solution {

  // 左上右下
  private int[] x = new int[] {-1, 0, 1, 0};
  private int[] y = new int[] {0, 1, 0, -1};

  private int row;
  private int col;

  public void solve(char[][] board) {
    if (null == board) return;
    row = board.length;
    if (row == 0) return;
    col = board[0].length;
    if (col == 0) return;
    for (int i = 0; i < row; i++) {
      if (board[i][0] == 'O') {
        mark(board, i, 0);
      }
      if (board[i][col - 1] == 'O') {
        mark(board, i, col - 1);
      }
    }
    for (int j = 0; j < col; j++) {
      if (board[0][j] == 'O') {
        mark(board, 0, j);
      }
      if (board[row - 1][j] == 'O') {
        mark(board, row - 1, j);
      }
    }

    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        if (board[i][j] == 'O') {
          board[i][j] = 'X';
        } else if (board[i][j] == 'm') {
          board[i][j] = 'O';
        }
      }
    }
  }

  void mark(char[][] board, int i, int j) {

    Queue<int[]> queue = new LinkedList<>();
    queue.offer(new int[] {i, j});
    board[i][j] = 'm';
    while (!queue.isEmpty()) {
      int[] p1 = queue.poll();
      for (int k = 0; k < 4; k++) {
        int a = p1[0], b = p1[1];
        int xi = a + x[k], yi = b + y[k];
        if (xi >= 0 && xi < row && yi >= 0 && yi < col && board[xi][yi] == 'O') {
          board[xi][yi] = 'm';
          queue.offer(new int[] {xi, yi});
        }
      }
    }
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    char[][] board =
        new char[][] {
          {'X', 'X', 'X', 'X'},
          {'X', 'O', 'O', 'X'},
          {'X', 'X', 'O', 'X'},
          {'X', 'O', 'X', 'X'},
        };
    s.solve(board);
    for (char[] row : board) {
      for (char c : row) {
        System.out.print(c + ", ");
      }
      System.out.println();
    }
  }
}
