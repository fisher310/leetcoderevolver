package p131;

import javax.swing.text.StyledEditorKit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 输入：s = "aab"
 * 输出：[["a","a","b"],["aa","b"]]
 *
 * @author lihailong
 * @since 2021/04/09 10:50:01
 */
class Solution {

    private boolean[][] f;
    private List<List<String>> res;
    private List<String> ans;
    private int n;

    public List<List<String>> partition(String s) {
        n = s.length();
        f = new boolean[n][n];
        res = new ArrayList<>();
        ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            Arrays.fill(f[i], true);
        }

        for (int i = n - 2; i >= 0; --i) {
            for (int j = i + 1; j < n; ++j) {
                f[i][j] = (s.charAt(i) == s.charAt(j)) && f[i + 1][j - 1];
            }
        }

        dfs(s, 0);

        return res;
    }

    private void dfs(String s, int i) {
        if (i == n) {
            res.add(new ArrayList<>(ans));
            return;
        }

        for (int j = i; j < n; j++) {
            if (f[i][j]) {
                ans.add(s.substring(i, j + 1));
                dfs(s, j + 1);
                ans.remove(ans.size() - 1);
            }
        }
    }
}
