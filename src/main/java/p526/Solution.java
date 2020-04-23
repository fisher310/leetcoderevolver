package p526;

import java.util.Arrays;

/** 优美的排列 */
public class Solution {

    private int ans = 0;

    public int countArrangement(int N) {
        ans = 0;
        boolean[] visited = new boolean[N + 1];
        dfs(1, N, visited);
        return ans;
    }

    void dfs(int i, int N, boolean[] visited) {
        if (i == N+1) {
            System.out.println(Arrays.toString(visited));
            System.out.println("++++++++++++++++++++=");
            ans++;
            return;
        }

        for (int j = 1; j <= N; j++) {
            if (!visited[j]) {
                if (j % i == 0 || i % j == 0) {
                    visited[j] = true;
                    System.out.println(i + ":" + j + ", ");
                    dfs(i + 1, N, visited);
                    visited[j] = false;
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int ans = s.countArrangement(15);
        System.out.println(ans);
    }
}
