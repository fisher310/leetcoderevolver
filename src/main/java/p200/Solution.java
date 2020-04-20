package p200;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 岛屿数量
 *
 * <p>示例 1:
 *
 * <p>输入: <br>
 * 11110 <br>
 * 11010 <br>
 * 11000 <br>
 * 00000 <br>
 * 输出: 1 示例 2:
 *
 * <p>输入: 11000 11000 00100 00011 输出: 3 解释: 每座岛屿只能由水平和/或竖直方向上相邻的陆地连接而成。
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/number-of-islands
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {
    int count = 0;

    private int[] dx = {1, 0, -1, 0};
    private int[] dy = {0, -1, 0, 1};
    int row;
    int col;

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;

        count = 0;
        row = grid.length;
        col = grid[0].length;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    bsf(grid, i, j);
//                    print(grid);
//                    System.out.println("==========================");
                }
            }
        }

        return count;
    }

    void bsf(char[][] grid, int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {i, j});
        grid[i][j] = 'm';
        while (!queue.isEmpty()) {
            int[] p = queue.poll();
            for (int d = 0; d < 4; d++) {
                int cx = p[0] + dx[d];
                int cy = p[1] + dy[d];
                if (cx >= 0 && cx < row && cy >= 0 && cy < col && grid[cx][cy] == '1') {
                    grid[cx][cy] = 'm';
                    queue.offer(new int[] {cx, cy});
                }
            }
        }
    }

    void print(char[][] grid) {
        for (char[] row : grid) {
            System.out.println(Arrays.toString(row));
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int ans =
                s.numIslands(
                        new char[][] {
                            {'1', '1', '1', '1', '0'},
                            {'1', '1', '0', '1', '0'},
                            {'1', '1', '0', '0', '0'},
                            {'0', '0', '0', '0', '0'}
                        });
        System.out.println(ans);
    }
}
