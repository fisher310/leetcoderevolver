package p51;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * 
 * 
 * 
 * 上图为 8 皇后问题的一种解法。
 * 
 * 给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。
 * 
 * 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 * 
 * 示例:
 * 
 * 输入: 4 输出: [ <br>
 * [".Q..", // 解法 1 <br>
 * "...Q", <br>
 * "Q...", <br>
 * "..Q."], <br>
 *
 * ["..Q.", // 解法 2 <br>
 * "Q...", <br>
 * "...Q", <br>
 * ".Q.."] <br>
 * ] <br>
 * 解释: 4 皇后问题存在两个不同的解法。
 */
class Solution {
    Set<Integer> colSet = new HashSet<>();
    Set<Integer> slashSet = new HashSet<>();
    Set<Integer> backSlashSet = new HashSet<>();

    List<List<String>> ans = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {

        int[][] board = new int[n][n];
        dfs(0, n, board);
        return ans;
    }

    void dfs(int row, int n, int[][] board) {
        if (row >= n) {
            List<String> oneSolver = new ArrayList<>();
            for (int i = 0, l = board.length; i < l; i++) {
                String line = "";
                for (int j = 0, m = board[0].length; j < m; j++) {
                    line += board[i][j] == 1 ? "Q" : ".";
                }
                oneSolver.add(line);
            }
            ans.add(oneSolver);
            return;
        }
        for (int col = 0; col < n; col++) {
            if (colSet.contains(col) || slashSet.contains(row + col) || backSlashSet.contains(row - col)) {
                continue;
            }
            board[row][col] = 1;
            colSet.add(col);
            slashSet.add(row + col);
            backSlashSet.add(row - col);

            dfs(row + 1, n, board);

            board[row][col] = 0;
            colSet.remove(col);
            slashSet.remove(row + col);
            backSlashSet.remove(row - col);
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solveNQueens(5).size());
    }

}