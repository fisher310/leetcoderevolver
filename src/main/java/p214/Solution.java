package p214;

import org.junit.Assert;


class Solution {
    public String shortestPalindrome(String s) {
        String rev = new StringBuilder(s).reverse().toString();

        int n = s.length();
        for (int i = 0; i < s.length(); i++) {
            if (s.substring(0, n - i).equals(rev.substring(i))) {
                return rev.substring(0, i) + s;
            }
        }

        return "";
    }


    private String reverse(String s) {
        int l = 0, r = s.length() - 1;
        char[] ch = s.toCharArray();
        while (l < r) {
            char tmp = ch[l];
            ch[l] = ch[r];
            ch[r] = tmp;
            l++;
            r--;
        }
        return new String(ch);
    }


    private boolean isPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        Assert.assertEquals("aaacecaaa", s.shortestPalindrome("aacecaaa"));
        Assert.assertEquals("dcbabcd", s.shortestPalindrome("abcd"));
    }
}
