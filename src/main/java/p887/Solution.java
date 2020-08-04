package p887;

import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;

class Solution {

    public int superEggDrop(int K, int N) {
        return dp(K, N);
    }

    Map<String, Integer> memo = new HashMap<>();

    int dp(int K, int N) {
        if (!memo.containsKey(N + "_" + K)) {
            int ans;
            if (N == 0) ans = 0;
            else if (K == 1) ans = N;
            else {
                int lo = 1, hi = N;
                while (lo + 1 < hi) {
                    int mid = (lo + hi) / 2;
                    int t1 = dp(K - 1, mid - 1);
                    int t2 = dp(K, N - mid);

                    if (t1 < t2) lo = mid;
                    else if (t1 > t2) hi = mid;
                    else lo = hi = mid;
                }
                ans = 1 + Math.min(
                        Math.max(dp(K - 1, lo - 1), dp(K, N - lo)),
                        Math.max(dp(K - 1, hi - 1), dp(K, N - hi)));
            }

            memo.put(N + "_" + K, ans);
        }

        return memo.get(N + "_" + K);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        Assert.assertEquals(2, s.superEggDrop(1, 2));
        Assert.assertEquals(3, s.superEggDrop(2, 6));
        Assert.assertEquals(4, s.superEggDrop(3, 14));
        Assert.assertEquals(4, s.superEggDrop(2, 10));
    }
}
