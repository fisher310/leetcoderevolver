package p1551;

import org.junit.Assert;

class Solution {

    public int minOperations(int n) {
        int half = n / 2;
        int ans = 0;
        for (int i = 0; i < half; i++) {
            ans += n - ((i * 2) + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        Assert.assertEquals(2, s.minOperations(3));
        Assert.assertEquals(9, s.minOperations(6));
    }

}
