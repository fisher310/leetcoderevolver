package p132;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author lihailong
 * @since 2021/04/09 14:34:24
 */
class Solution {

    private boolean[][] f;
    private List<String> res;

    private int ans;
    private int n;

    public int minCut(String s) {
        res = new ArrayList<>();
        n = s.length();
        ans = n;
        f = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(f[i], true);
        }

        for (int i = n - 2; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                f[i][j] = (s.charAt(i) == s.charAt(j)) && f[i + 1][j - 1];
            }
        }

        dfs(s, 0);
        return ans;
    }

    private void dfs(String s, int i) {
        if (i == n) {
            ans = Math.min(ans, res.size() - 1);
            return;
        }

        for (int j = i; j < n; j++) {
            if (f[i][j]) {
                res.add(s.substring(i, j + 1));
                dfs(s, j + 1);
                res.remove(res.size() - 1);
            }
        }
    }
}
