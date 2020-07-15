package test;

import java.util.HashSet;
import java.util.Set;

class Solution2 {

    int ans = 0;
    Set<Integer> col = new HashSet<>();
    Set<Integer> diag1 = new HashSet<>();
    Set<Integer> diag2 = new HashSet<>();

    public int totalNQueens(int n) {
        dfs(n, 0);
        return ans;
    }

    private void dfs(int n, int i) {
        if (i == n) {
            ans++;
            return;
        }

        for (int j = 0; j < n; j++) {
            if (!col.contains(j) && !diag1.contains(i + j) && !diag2.contains(j - i)) {
                col.add(j);
                diag1.add(i + j);
                diag2.add(j - i);
                dfs(n, i + 1);
                col.remove(j);
                diag1.remove(i + j);
                diag2.remove(j - i);
            }
        }
    }

    public static void main(String[] args) {
        //        Solution2 s = new Solution2();
        //        System.out.println(s.totalNQueens(3));
        System.out.println(Integer.toBinaryString(6 & 5));
    }
}
