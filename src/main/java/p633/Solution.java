package p633;

/** 平方数之和 */
class Solution {
    public boolean judgeSquareSum(int c) {

        for (long i = 0, ii = 0; ii <= c; i++) {
            ii = i * i;
            for (int j = 0, jj = 0; j <= c; j++) {
                jj = j * j;
                long sum = ii + jj;
                if (sum == c) {
                    return true;
                } else if (sum > c) {
                    break;
                }
            }
        }
        return false;
    }
}
