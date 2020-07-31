package p926;

import org.junit.Assert;

class Solution {

    public int minFlipsMonoIncr(String s) {
        int N = s.length();
        char[] ch = s.toCharArray();
        int[] p = new int[N+1];

        for (int i = 1; i <= N; i++) {
            p[i] = p[i - 1] + (ch[i-1] - '0');
        }

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i <= N; i++) {
            ans = Math.min(ans, p[i] + (N - i - p[N] + p[i]));
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        Assert.assertEquals(1, s.minFlipsMonoIncr("11011"));
        Assert.assertEquals(2, s.minFlipsMonoIncr("010110"));
        Assert.assertEquals(2, s.minFlipsMonoIncr("00011000"));
    }
}
