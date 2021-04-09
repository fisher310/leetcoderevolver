package p132;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * aab -> 1   a -> 0   ab -> 1
 *
 * @author lihailong
 * @since 2021/04/09 14:34:24
 */
class Solution {

    public int minCut(String s) {
        int n = s.length();
        boolean[][] f = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(f[i], true);
        }

        for (int i = n - 2; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                f[i][j] = (s.charAt(i) == s.charAt(j)) && f[i + 1][j - 1];
            }
        }

        int[] g = new int[n];
        Arrays.fill(g, Integer.MAX_VALUE);
        for (int i = 0; i < n; i++) {
            if (f[0][i]) {
                g[i] = 0;
            } else {
                for (int j = 0; j < i; j++) {
                    if (f[j + 1][i]) {
                        g[i] = Math.min(g[i], g[j] + 1);
                    }
                }
            }
        }

        return g[n - 1];
    }

}
