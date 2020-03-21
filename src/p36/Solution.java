package p36;

import java.util.HashSet;

/** 验证数独 */
public class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet[] rowSet = new HashSet[9];
        HashSet[] colSet = new HashSet[9];
        HashSet[][] blockSet = new HashSet[3][3];
        for (int i = 0; i < 9; i++) {
            rowSet[i] = new HashSet<Character>();
            colSet[i] = new HashSet<Character>();
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                blockSet[i][j] = new HashSet<Character>();
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                char value = board[i][j];
                if (value == '.') {
                    continue;
                }
                if (rowSet[i].contains(value) || colSet[j].contains(value) || blockSet[i / 3][j / 3].contains(value)) {
                    return false;
                }
                rowSet[i].add(value);
                colSet[j].add(value);
                blockSet[i / 3][j / 3].add(value);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] board = new char[][] { { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
                { '6', '.', '.', '1', '9', '5', '.', '.', '.' }, { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
                { '8', '.', '.', '.', '6', '.', '.', '.', '3' }, { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
                { '7', '.', '.', '.', '2', '.', '.', '.', '6' }, { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
                { '.', '.', '.', '4', '1', '9', '.', '.', '5' }, { '.', '.', '.', '.', '8', '.', '.', '7', '9' } };
        Solution s = new Solution();
        System.out.println(s.isValidSudoku(board));
    }
}
