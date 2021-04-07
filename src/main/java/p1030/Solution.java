package p1030;

import org.openjdk.jmh.annotations.Benchmark;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author lihailong
 * @since 2021-03-31 22:18:31
 */
class Solution {


    @Benchmark
    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {

        int[][] res = new int[R * C][2];

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                res[i * C + j][0] = i;
                res[i * C + j][1] = j;
            }
        }

        Arrays.sort(res, new Comparator<int[]>() {
            @Override
            public int compare(int[] p1, int[] p2) {
                return Math.abs(p1[0] - r0) + Math.abs(p1[1] - c0) - Math.abs(p2[0] - r0) - Math.abs(p2[1] - c0);
            }
        });

        return res;
    }
}
