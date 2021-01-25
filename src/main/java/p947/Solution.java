package p947;

import java.util.Arrays;

/**
 * @author lihailong
 * @since 2021/1/15 0015
 */
class Solution {

    int[] ufd = new int[20001];

    public int removeStones(int[][] stones) {

        int n = stones.length;
        Arrays.fill(ufd, -1);

        for (int i = 0; i < stones.length; i++) {
            union(stones[i][0], stones[i][1] + 10001);
        }

        return n - count();
    }

    private void union(int i, int j) {
        int pi = find(i);
        int pj = find(j);
        if (pi != pj) ufd[find(i)] = find(j);
    }

    private int find(int j) {
        if (ufd[j] < 0) {
            ufd[j] = j;
        }
        if (ufd[j] != j) {
            ufd[j] = find(ufd[j]);
        }
        return ufd[j];
    }

    private int count() {
        int c = 0;
        for (int i = 0; i < ufd.length; i++) {
            if (i == ufd[i]) {
                c++;
            }
        }
        return c;
    }
}
