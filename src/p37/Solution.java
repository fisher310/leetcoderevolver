package p37;

import java.util.HashSet;

/**
 * 解数独 编写一个程序，通过已填充的空格来解决数独问题。
 *
 * <p>一个数独的解法需遵循如下规则：
 *
 * <p>数字 1-9 在每一行只能出现一次。<br>
 * 数字 1-9 在每一列只能出现一次。 <br>
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。 <br>
 * 空白格用 '.' 表示。
 */
public class Solution {
  HashSet[] rowSets = new HashSet[9];
  HashSet[] colSets = new HashSet[9];
  HashSet[][] blockSets = new HashSet[3][3];

  public void solveSudoku(char[][] board) {
    if (null == board || board.length == 0) {
      return;
    }
    //    for (int i = 0; i < 9; i++) {
    //      rowSets[i] = new HashSet<Character>();
    //      colSets[i] = new HashSet<Character>();
    //    }
    //    for (int i = 0; i < 3; i++) {
    //      for (int j = 0; j < 3; j++) {
    //        blockSets[i][j] = new HashSet<Character>();
    //      }
    //    }
    //    for (int i = 0; i < board.length; i++) {
    //      for (int j = 0; j < board[0].length; j++) {
    //        if (board[i][j] != '.') {
    //          rowSets[i].add(board[i][j]);
    //          colSets[j].add(board[i][j]);
    //          blockSets[i / 3][j / 3].add(board[i][j]);
    //        }
    //      }
    //    }
    solve(board);
  }

  private boolean solve(char[][] board) {
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        if (board[i][j] == '.') {
          for (char c = '1'; c <= '9'; c++) {
            if (isValid(board, i, j, c)) {
              board[i][j] = c;
              if (solve(board)) {
                return true;
              } else {
                board[i][j] = '.';
              }
            }
          }
          return false;
        }
      }
    }
    return true;
  }

  private boolean isValid(char[][] board, int row, int col, char value) {
    for (int i = 0; i < 9; i++) {
      if (board[i][col] != '.' && board[i][col] == value) return false;
      if (board[row][i] != '.' && board[row][i] == value) return false;
      if (board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == value) return false;
    }
    return true;
  }

  public static void main(String[] args) {
    char[][] board =
        new char[][] {
          {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
          {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
          {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
          {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
          {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
          {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
          {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
          {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
          {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
    Solution s = new Solution();
    s.solveSudoku(board);
    print(board);
  }

  private static void print(char[][] board) {
    for (char[] row : board) {
      for (char c : row) {
        System.out.print(c + " ");
      }
      System.out.println();
    }
    System.out.println("===============================");
  }
}
