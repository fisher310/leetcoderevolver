package p372;

/** 超级次方 */
class Solution {

    public int superPow(int a, int[] b) {
        // 1337
        int base = 1337;

        long ans = 1;

        for (int i = 0; i < b.length; i++) {
            ans = power(ans, 10, base) * power(a, b[i], base) % base;
        }

        return (int) ans;
    }

    private long power(long a, int n, int base) {
        if (n == 0) {
            return 1;
        }

        long res = power(a, n / 2, base);
        res = res * res % base;
        if ((n & 1) == 1) res = res * a % base;
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.superPow(2, new int[] {1, 0}));
        System.out.println(s.superPow(18, new int[] {1, 2, 0, 0}));
    }
}
