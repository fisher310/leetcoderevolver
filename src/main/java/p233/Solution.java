package p233;

import static org.junit.Assert.assertEquals;

class Solution {

    public int countDigitOne(int n) {

        long mulk = 1;
        int ans = 0;
        for (int k = 0; n >= mulk; k++) {
            ans += (n / (mulk * 10)) * mulk + Math.min(Math.max(n % (mulk * 10) - mulk + 1, 0), mulk);
            mulk *= 10;
        }

        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        assertEquals(1, s.countDigitOne(1));
        assertEquals(6, s.countDigitOne(13));
        assertEquals(0, s.countDigitOne(0));
        System.out.println("ok");
    }

}
