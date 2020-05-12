package m008dot01;

/** */
class solution {

    public int waysToChange(int n) {
        long[] dp = new long[Math.max(n + 1, 26)];
        int[] dx = {1, 5, 10, 25};
        dp[0] = 1;

        // dp[1] = 1 dp[2] = 1, dp[3]=1, dp[4]=1 dp[5]=2,
        // dp[6] = 2 dp[7] = 2, dp[8]=2, dp[9]=2 dp[10]=dp[9] + dp[5] + 1=4,
        // dp[11] = dp[10]=4 dp[12]=dp[10]=4, dp[13]=dp[10]=4 dp[14] = 4,
        // dp[15]= dp[14] + dp[10] + dp[5]= 4 + 4 + 2
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < 4; j++) {
                int dj = i - dx[j];
                if (dj >= 0) {
                    dp[i] += dp[dj];
                }
            }
        }
        return (int) (dp[n] % 1000000007);
    }

    public static void main(String[] args) {
        solution s = new solution();
        int ans = s.waysToChange(10);
        System.out.println(ans);
    }
}
