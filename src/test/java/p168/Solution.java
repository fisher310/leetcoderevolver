package p168;

import org.junit.Assert;

class Solution {

    public String convertToTitle(int n) {

        String[] tab = new String[]{"Z", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J",
                "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};

        StringBuilder res = new StringBuilder();

        int i = 0;
        while (n > 0) {
            if (n % 26 == 0) {
                res.insert(0, tab[n % 26]);
                n = n / 26 - 1;
            } else {
                res.insert(0, tab[n % 26]);
                n /= 26;
            }
        }

        return res.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        Assert.assertEquals("AZ", s.convertToTitle(52));
        Assert.assertEquals("AA", s.convertToTitle(27));
        Assert.assertEquals("Z", s.convertToTitle(26));
        Assert.assertEquals("ZY", s.convertToTitle(701));

    }
}
