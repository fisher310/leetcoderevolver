package p69;

/** x 的平方根 */
class Solution {
    public int mySqrt(int x) {
        if (x == 1) return 1;
        long i = 1;
        while (i * i <= x) {
            i++;
        }

        return (int) (i - 1);
    }
}
