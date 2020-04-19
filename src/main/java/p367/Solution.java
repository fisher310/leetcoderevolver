package p367;

/**
 * 有效的完全平方数
 */
class Solution {
    public boolean isPerfectSquare(int num) {
        if (num == 0 || num == 1) return true;

        long l = 1;
        long r = (long) num + 1;
        while (l < r) {
            long mid = l + (r-l) /2;
            long pow = mid * mid;
            if (pow == num) {
                return true;
            } else if (pow < num) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return false;
    }
}
