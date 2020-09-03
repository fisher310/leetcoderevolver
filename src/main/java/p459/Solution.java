package p459;


import org.junit.Assert;

class Solution {
    public boolean repeatedSubstringPattern(String s) {

        int len = s.length();
//        if ((len & 1) == 1) return false;

        char c = s.charAt(len - 1);

        for (int i = 0; i < len - 1; i++) {
            if (s.charAt(i) == c) {
                int sub = i + 1;
                if (len % sub == 0) {
                    // [0, sub)
                    int curr = sub;
                    while (curr < len) {
                        if (s.substring(0, sub).equals(s.substring(curr, curr + sub))) {
                            curr += sub;
                        } else {
                            break;
                        }
                    }
                    if (curr == len) return true;
                }

            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        Assert.assertTrue(s.repeatedSubstringPattern("abcabcabc"));
        Assert.assertTrue(s.repeatedSubstringPattern("abab"));
        Assert.assertFalse(s.repeatedSubstringPattern("aba"));
    }
}
