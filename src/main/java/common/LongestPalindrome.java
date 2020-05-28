package common;

public class LongestPalindrome {

    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) return s;
        int min = s.length();
        int max = -1;
        for (int k = 0; k < s.length(); k++) {
            int i = k - 1, j = k + 1;
            while (i >= 0 && j < s.length()) {
                if (s.charAt(i) != s.charAt(j)) {
                    break;
                }
                i--;
                j++;
            }
            if (j - i - 2 > (max - min)) {
                min = Math.min(min, i + 1);
                max = Math.max(max, j - 1);
            }
        }

        if (max == -1) {
            return "";
        }
        return s.substring(min, max + 1);
    }

    public static void main(String[] args) {
        LongestPalindrome lp = new LongestPalindrome();
        String s = lp.longestPalindrome("ababc");
        System.out.println(s);
        System.out.println(lp.longestPalindrome("ababad"));
    }
}
