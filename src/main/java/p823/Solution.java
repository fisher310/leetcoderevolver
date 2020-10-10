package p823;

import org.junit.Assert;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {

    public int numFactoredBinaryTrees(int[] A) {
        int MOD = 1_000_000_007;
        int n = A.length;
        Arrays.sort(A);
        long[] dp = new long[n];
        Arrays.fill(dp, 1);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(A[i], i);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (A[i] % A[j] == 0) {
                    int right = A[i] / A[j];
                    if (map.containsKey(right)) {
                        dp[i] = (dp[i] + dp[j] * dp[map.get(right)]) % MOD;
                        System.out.println(Arrays.toString(dp));
                    }
                }
            }
        }

        long ans = 0;
        for (long d : dp) {
            ans = (ans + d) % MOD;
        }
        return (int) ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        Assert.assertEquals(3, s.numFactoredBinaryTrees(new int[]{2, 4}));
        Assert.assertEquals(12, s.numFactoredBinaryTrees(new int[]{2, 3, 4, 6}));
    }
}
