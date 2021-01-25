package p959;

/**
 * @author lihailong
 * @since 2021/1/25 0025
 */
class Solution {

    private int[] ufd;

    public int regionsBySlashes(String[] grid) {
        int N = grid.length;

        int len = 4 * N * N;

        ufd = new int[len];
        for (int i = 0; i < len; i++) {
            ufd[i] = i;
        }

        for (int i = 0; i < N; i++) {
            for (int col = 0; col < grid[i].length(); col++) {
                // i is the row
                // col is the column
                int left = 4 * (i * N + col);
                int up = left + 1;
                int right = up + 1;
                int down = right + 1;
                char c = grid[i].charAt(col);
                switch (c) {
                    case ' ':
                        // union four
                        union(left, up);
                        union(left, right);
                        union(left, down);
                        break;
                    case '/':
                        // union left and up, right and down
                        union(left, up);
                        union(right, down);
                        break;
                    case '\\':
                        // union left and down, right and up
                        union(left, down);
                        union(right, up);
                        break;
                }
                // check and union left with the last right, and so on...
                if (i > 0) {
                    // up , last up
                    int lastDown = 4 * ((i - 1) * N + col) + 3;
                    union(up, lastDown);
                }
                //                if (i < N - 1) {
                //                    // down, next up
                //                    int nextUp = 4 * ((i + 1) * N + col) + 1;
                //                    union(down, nextUp);
                //                }

                if (col > 0) {
                    // left, last right
                    int lastRight = 4 * (i * N + col - 1) + 2;
                    union(left, lastRight);
                }

                //                if (col < N - 1) {
                //                    // right, next left
                //                    int nextLeft = 4 * (i * N + col + 1);
                //                    union(right, nextLeft);
                //                }
            }
        }

        //        print(ufd, 4 * N);

        return region();
    }

    private void union(int u, int v) {

        int p = find(u);
        int q = find(v);
        if (p == q) {
            return;
        }

        ufd[p] = q;
    }

    private int find(int u) {
        if (ufd[u] != u) {
            ufd[u] = find(ufd[u]);
        }
        return ufd[u];
    }

    private int region() {
        int ans = 0;
        for (int i = 0; i < ufd.length; i++) {
            if (i == ufd[i]) {
                ans++;
            }
        }
        return ans;
    }

    private void print(int[] ufd, int N) {
        for (int i = 0; i < ufd.length; i++) {
            System.out.print(ufd[i] + "(" + i + ")\t");
            if ((i + 1) % N == 0) {
                System.out.println();
            }
        }
    }
}
