package p529;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * 如果一个地雷（'M'）被挖出，游戏就结束了- 把它改为 'X'。
 * 如果一个没有相邻地雷的空方块（'E'）被挖出，修改它为（'B'），并且所有和其相邻的未挖出方块都应该被递归地揭露。
 * 如果一个至少与一个地雷相邻的空方块（'E'）被挖出，修改它为数字（'1'到'8'），表示相邻地雷的数量。
 * 如果在此次点击中，若无更多方块可被揭露，则返回面板。
 */
class Solution {

    private final int[] dx = new int[]{0, 1, 0, -1, 1, -1, -1, 1};
    private final int[] dy = new int[]{1, 0, -1, 0, 1, 1, -1, -1};

    public char[][] updateBoard(char[][] board, int[] click) {

        int row = board.length;
        int col = board[0].length;
        Queue<int[]> queue = new LinkedList<>();
        // 踩到雷，结束
        if (board[click[0]][click[1]] == 'M') {
            board[click[0]][click[1]] = 'X';
            return board;
        }

        Set<String> visit = new HashSet<>();
        visit.add(click[0] + "_" + click[1]);
        queue.offer(click);
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int i = curr[0], j = curr[1];

            if (board[i][j] == 'E') {
                // 查看四周，如果有M，计算M个数，如果是E，继续
                int num = 0;
                for (int k = 0; k < 8; k++) {
                    int x = dx[k] + i;
                    int y = dy[k] + j;


                    if (x >= 0 && x < row && y >= 0 && y < col && !visit.contains(x + "_" + y)) {
                        if (board[x][y] == 'M') {
                            num++;
                        }
                    }
                }

                for (int k = 0; k < 8; k++) {
                    int x = dx[k] + i;
                    int y = dy[k] + j;


                    if (x >= 0 && x < row && y >= 0 && y < col && !visit.contains(x + "_" + y)) {
                        if (board[x][y] == 'E' && num == 0) {
                            visit.add(x + "_" + y);
                            queue.offer(new int[]{x, y});
                        }
                    }
                }


                board[i][j] = num > 0 ? (char) ('0' + num) : 'B';
            }
//            print(board);
        }

        return board;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        char[][] ch = s.updateBoard(new char[][]{
                {'E', 'E', 'E', 'E', 'E'},
                {'E', 'E', 'M', 'E', 'E'},
                {'E', 'E', 'E', 'E', 'E'},
                {'E', 'E', 'E', 'E', 'E'},
        }, new int[]{3, 0});

        print(ch);
    }

    private static void print(char[][] ch) {
        for (int i = 0; i < ch.length; i++) {
            for (int j = 0; j < ch[0].length; j++) {
                System.out.print(ch[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("--------------------------");
    }
}
