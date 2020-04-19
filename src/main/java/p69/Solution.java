package p69;

/** x 的平方根 */
class Solution {
    public int mySqrt(int x) {
        if (x == 1) return 1;
        long l = 1;
        long r = (long) x+1;

        while (l < r) {
            long mid = l + (r - l) / 2;
            long floor = mid * mid;
            long ceil = (mid + 1) * (mid + 1);
            if (floor <= x && x < ceil) {
                return (int) mid;
            } else if (ceil <= x) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }

        return (int) l;
    }
}
