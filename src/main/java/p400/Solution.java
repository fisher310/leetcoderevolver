package p400;

import org.junit.Assert;

/**
 * 1-9 9 = 9 <br>
 * 10 ~ 99 90 * 2 = 189 <br>
 * 100 ~ 999 900 * 3 = 2889 <br>
 * 1000 ~ 9999 9000 * 4 = 38889 <br>
 * 10000 ~ 99999 90000 * 5 = 488889 <br>
 * 100000 ~ 999999 900000 * 6 = 5888889 <br>
 * 1000000 ~ 9999999 9000000 * 7 = * 68888889 <br>
 * 10000000 ~ 99999999 90000000 * 8 = 788888889 <br>
 * 100000000 ~ 999999999 900000000 * 9 = 8888888889 <br>
 */
class Solution {

    public int findNthDigit(int n) {
        if (n > 788888889) {
            int x = 1_0000_0000 + (n - 788888889 - 1) / 9;
            int index = (n - 788888889 - 1) % 9;
            return String.valueOf(x).charAt(index) - '0';
        }
        if (n > 68888889) {
            int x = 1000_0000 + (n - 68888889 - 1) / 8;
            int index = (n - 68888889 - 1) % 8;
            return String.valueOf(x).charAt(index) - '0';
        }
        if (n > 5888889) {
            int x = 100_0000 + (n - 5888889 - 1) / 7;
            int index = (n - 5888889 - 1) % 7;
            return String.valueOf(x).charAt(index) - '0';
        }
        if (n > 488889) {
            int x = 10_0000 + (n - 488889 - 1) / 6;
            int index = (n - 488889 - 1) % 6;
            return String.valueOf(x).charAt(index) - '0';
        }
        if (n > 38889) {
            int x = 1_0000 + (n - 38889 - 1) / 5;
            int index = (n - 38889 - 1) % 5;
            return String.valueOf(x).charAt(index) - '0';
        }
        if (n > 2889) {
            int x = 1_000 + (n - 2889 - 1) / 4;
            int index = (n - 2889 - 1) % 4;
            return String.valueOf(x).charAt(index) - '0';
        }
        if (n > 189) {
            int x = 100 + (n - 189 - 1) / 3;
            int index = (n - 189 - 1) % 3;
            return String.valueOf(x).charAt(index) - '0';
        }
        // 10 ~ 99
        if (n > 9) {
            int x = 10 + (n - 9 - 1) / 2;
            int index = (n - 9 - 1) % 2;
            return String.valueOf(x).charAt(index) - '0';
        }
        return n;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        Assert.assertEquals(7, s.findNthDigit(9999));
        Assert.assertEquals(7, s.findNthDigit(10000));
        Assert.assertEquals(3, s.findNthDigit(1000));
        Assert.assertEquals(0, s.findNthDigit(11));
    }
}
