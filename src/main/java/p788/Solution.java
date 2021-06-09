package p788;

/**
 * 10: 2, 5, 6, 9
 *
 * @author lihailong
 * @since 2021/06/09 10:53:47
 */
class Solution {

    int[] table = new int[10];
    boolean[] bad = new boolean[10001];

    Solution() {
        table[0] = 0;
        table[1] = 1;
        table[2] = 5;
        table[3] = -1;
        table[4] = -1;
        table[5] = 2;
        table[6] = 9;
        table[7] = -1;
        table[8] = 8;
        table[9] = 6;
    }

    public int rotatedDigits(int n) {
        if (n < 2) return 0;
        int ans = 0;
        for (int i = 2; i <= n; i++) {
            if (isGood(i)) {
                ans++;
            }
        }

        return ans;
    }

    private boolean isGood(int n) {
        int o = n;
        int m = 0;
        int p = 0;
        while (n > 0) {
            if (bad[n]) return false;
            int t = table[n % 10];
            if (t == -1) {
                bad[o] = true;
                return false;
            }
            m += Math.pow(10, p++) * t;
            n /= 10;
        }
        return m != o;
    }
}
