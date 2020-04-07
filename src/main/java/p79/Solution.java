package p79;

import java.util.HashSet;
import java.util.Set;

/** 单词搜索 */
class Solution {

  private int row;
  private int col;
  private int len;
  private int[] x = {-1, 0, 1, 0};
  private int[] y = {0, -1, 0, 1};

  public boolean exist(char[][] board, String word) {
    char[] wc = word.toCharArray();
    row = board.length;
    col = board[0].length;
    len = word.length();

    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        if (board[i][j] == wc[0]) {
          //          if (len == 1) return true;
          if (dfs(board, wc, 1, i, j, new HashSet<>())) {
            return true;
          }
        }
      }
    }
    return false;
  }

  boolean dfs(char[][] board, char[] word, int k, int i, int j, Set<String> visited) {
    if (k == len) return true;

    visited.add(i + "_" + j);
    for (int m = 0; m < 4; m++) {
      int xm = i + x[m];
      int ym = j + y[m];
      if (isValid(xm, ym) && !visited.contains(xm + "_" + ym) && board[xm][ym] == word[k]) {
        if (dfs(board, word, k + 1, xm, ym, visited)) {
          return true;
        }
        visited.remove(xm + "_" + ym);
      }
    }
    return false;
  }

  private boolean isValid(int x, int y) {
    return x >= 0 && x < row && y >= 0 && y < col;
  }
}
