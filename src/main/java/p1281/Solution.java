package p1281;

import org.junit.Assert;

class Solution {

    public int subtractProductAndSum(int n) {
        int dot = 1;
        int sum = 0;
        while (n > 0) {
            int rem = n % 10;
            n = n / 10;
            dot *= rem;
            sum += rem;
        }
        return dot - sum;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        Assert.assertEquals(15, s.subtractProductAndSum(234));
        Assert.assertEquals(21, s.subtractProductAndSum(4421));
    }
}
