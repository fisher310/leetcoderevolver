package p441;

/** */
class Solution {
    public int arrangeCoins(int n) {
        if (n < 0) return 0;
        if (n <= 1) return n;

        long l = 0;
        long r = n;

        while (l < r) {

            long mid = l + (r - l) / 2;
            long sum = mid * (1 + mid) / 2;
            if (sum == n) {
                return (int) mid;
            } else if (sum < n) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return (int) (l - 1);
    }
}
