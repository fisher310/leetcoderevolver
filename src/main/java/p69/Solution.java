package p69;

/** x 的平方根 */
class Solution {
    public int mySqrt(int x) {
        if (x == 0 || x == 1) return x;

        double cur = 1;
        while (true) {
            double pre = cur;
            cur = (cur + x/cur) /2;
            if (Math.abs(cur - pre) < 1e-6) {
                return (int) cur;
            }
        }
//        long l = 1;
//        long r = (long) x+1;
//
//        while (l < r) {
//            long mid = l + (r - l) / 2;
//            long floor = mid * mid;
//            long ceil = (mid + 1) * (mid + 1);
//            if (floor <= x && x < ceil) {
//                return (int) mid;
//            } else if (ceil <= x) {
//                l = mid + 1;
//            } else {
//                r = mid;
//            }
//        }

//        return (int) l;
    }
}
