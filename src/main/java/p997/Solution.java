package p997;

import org.junit.Assert;

class Solution {

    public int findJudge(int N, int[][] trust) {

        int[] in = new int[N + 1];
        int[] out = new int[N + 1];

        for (int[] t : trust) {
            in[t[1]]++;
            out[t[0]]++;
        }

        for (int i = 1; i <= N; i++) {
            if (in[i] == N - 1 && out[i] == 0) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        Assert.assertEquals(2, s.findJudge(2, new int[][] {{1, 2}}));
        Assert.assertEquals(3, s.findJudge(3, new int[][] {{1, 3}, {2, 3}}));
        Assert.assertEquals(-1, s.findJudge(3, new int[][] {{1, 3}, {2, 3}, {3, 1}}));
        Assert.assertEquals(-1, s.findJudge(3, new int[][] {{1, 2}, {2, 3}}));
    }
}
