package p52;

import java.util.*;

public class Solution {
    Set<Integer> colSet = new HashSet<>();
    Set<Integer> slahSet = new HashSet<>();
    Set<Integer> backSlashSet = new HashSet<>();
    int ans = 0;

    public int totalNQueens(int n) {
        dfs(0, n);
        return ans;
    }

    void dfs(int row, int n) {
        if (row >= n) {
            ans++;
            return;
        }
        for (int col = 0; col < n; col++) {
            if (colSet.contains(col) || slahSet.contains(row + col) || backSlashSet.contains(row - col)) {
                continue;
            }
            colSet.add(col);
            slahSet.add(row + col);
            backSlashSet.add(row - col);
            dfs(row + 1, n);
            colSet.remove(col);
            slahSet.remove(row + col);
            backSlashSet.remove(row - col);
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.totalNQueens(4));
    }
}