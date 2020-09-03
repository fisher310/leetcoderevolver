package p258;

import org.junit.Assert;

class Solution {

    public int addDigits(int num) {
        while (num > 10) {

            int sum = 0;
            while (num > 0) {
                sum += (num % 10);
                num /= 10;
            }
            num = sum;
        }
        return num;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        Assert.assertEquals(2, s.addDigits(38));
    }
}
