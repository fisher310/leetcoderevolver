package p441;

/** */
class Solution {
    public int arrangeCoins(int n) {
        if (n < 0) return 0;
        if (n <= 1) return n;

        int l = 0;
        int r = n;

        while (l < r) {

            int mid = l + (r - l) / 2;
            long sum = (long) mid * (1 + (long) mid) / 2;
            if (sum == n) {
                return mid;
            } else if (sum < n) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l - 1;
    }
}
