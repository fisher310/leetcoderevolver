package p605;

import org.junit.Assert;

class Solution {

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int zero = 0;
        int ans = 0;
        boolean first_zero = (flowerbed[0] == 0);
        boolean u = false;
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 0) {
                zero++;
            } else if (zero > 0) {
                if (!u && first_zero) {
                    ans += zero / 2;
                } else {
                    ans += (zero - 1) / 2;
                }
                u = true;
                zero = 0;
            }
        }
        if (zero > 0) {
            if (first_zero && !u) {
                ans += (zero + 1) / 2;
            } else {
                ans += zero / 2;
            }
        }

        return ans >= n;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        Assert.assertEquals(true, s.canPlaceFlowers(new int[] { 1, 0, 0, 0, 1 }, 1));
        Assert.assertEquals(true, s.canPlaceFlowers(new int[] { 0, 0, 0 }, 2));
    }

}
