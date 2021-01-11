package p289;

import org.junit.Test;

/**
 * @author lihailong
 * @since 2021/1/9 0009
 */
public class SolutionTest {

    @Test
    public void gameOfLife() {
        Solution s = new Solution();

        //        assertArrayEquals(new int[][]{{0,0,0},{1,0,1},{0,1,1},{0,1,0}},
        int[][] board = new int[][] {{0, 1, 0}, {0, 0, 1}, {1, 1, 1}, {0, 0, 0}};
        s.gameOfLife(board);

        print(board);

        int[][] case2 = new int[][]{{1,1}, {1,0}};

        s.gameOfLife(case2);

        print(case2);

    }

    private void print(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
