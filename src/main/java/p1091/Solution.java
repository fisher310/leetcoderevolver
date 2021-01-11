package p1091;

import java.util.HashSet;
import java.util.Set;

/**
 * @author lihailong
 * @since 2020/12/16 0016
 */
class Solution {

    int[] dx = {0, 1, 0, -1, 1, 1, -1, -1};
    int[] dy = {1, 0, -1, 0, 1, -1, 1, -1};

    public int shortestPathBinaryMatrix(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        if (grid[0][0] == 1 || grid[r - 1][c - 1] == 1) return -1;
        if (r == 1 && c == 1) return 1;

        Set<Integer> start = new HashSet<>();
        Set<Integer> end = new HashSet<>();
        start.add(0);
        end.add(flat(r - 1, c - 1, c));
        Set<Integer> visited = new HashSet<>();
        visited.add(0);
        visited.add(flat(r - 1, c - 1, c));

        int step = 1;
        while (start.size() > 0 && end.size() > 0) {
            if (start.size() > end.size()) {
                Set<Integer> tmp = start;
                start = end;
                end = tmp;
            }
            step++;

            Set<Integer> levelVisited = new HashSet<>();
            Set<Integer> level = new HashSet<>();

            for (int pp : start) {
                int[] p = zip(pp, c);

                for (int i = 0; i < 8; i++) {
                    int nx = p[0] + dx[i];
                    int ny = p[1] + dy[i];

                    if (nx >= 0 && nx < r && ny >= 0 && ny < c && grid[nx][ny] == 0) {
                        int np = flat(nx, ny, c);
                        if (end.contains(np)) {
                            return step;
                        }
                        if (!visited.contains(np)) {
                            level.add(np);
                            levelVisited.add(np);
                        }
                    }
                }
            }

            visited.addAll(levelVisited);
            start = level;
        }

        return -1;
    }

    int flat(int x, int y, int c) {
        return x * c + y;
    }

    int[] zip(int v, int c) {
        return new int[] {v / c, v % c};
    }

    public static void main(String[] args) {
        Solution s = new Solution();
    }
}
