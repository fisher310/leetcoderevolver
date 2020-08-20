package p1545;

import org.junit.Assert;

/**
 * S1 = "0"
 * 当 i > 1 时，Si = Si-1 + "1" + reverse(invert(Si-1))
 */
class Solution {
    public char findKthBit(int n, int k) {
        String s = "0";

        for (int i = 2; i <= n; i++) {
            s = s + "1" + reverse(invert(s));
        }

        return s.charAt(k - 1);
    }

    private String reverse(char[] ch) {
        int l = 0;
        int r = ch.length - 1;
        while (l < r) {
            char tmp = ch[l];
            ch[l] = ch[r];
            ch[r] = tmp;
            l++;
            r--;
        }
        return new String(ch);
    }

    private char[] invert(String s) {
        char[] ch = s.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            ch[i] = ch[i] == '0' ? '1' : '0';
        }
        return ch;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        Assert.assertEquals('0', s.findKthBit(3, 1));
        Assert.assertEquals('1', s.findKthBit(4, 11));
        Assert.assertEquals('1', s.findKthBit(2, 3));
    }
}
