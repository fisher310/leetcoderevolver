package week285.p3;

import java.util.Arrays;

public class Solution {

    private int[][] cache;

    public int[] maximumBobPoints(int numArrows, int[] aliceArrows) {

        int sum = 0;
        for (int i = 0; i < aliceArrows.length; i++) {
            sum += aliceArrows[i];
        }
        cache = new int[13][sum + 1];
        for (int i = 0; i < cache.length; i++) {
            Arrays.fill(cache[i], -1);
        }

        return null;
    } 

    int dfs(int[] aliceArrows, int i, int sum) {
        if (sum <= 0 || i > 11) {
            return 0;
        }

        if (cache[i][sum] != -1) {
            return cache[i][sum];
        }

        int max = 0;
        max = Math.max(max, dfs(aliceArrows, i + 1, sum));
        max = Math.max(max, dfs(aliceArrows, i + 1, sum - aliceArrows[i] + 1) + i);

        cache[i][sum] = max;
        return max;
    }
}
