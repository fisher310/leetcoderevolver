package p925;

import org.junit.Assert;

class Solution {
    public boolean isLongPressedName(String name, String typed) {
        if (name == null || typed == null || name.length() == 0) return false;
        int m = name.length(), n = typed.length();
        if (m > n) return false;

        int i = 0, j = 0;
        char c = 0;
        while (i < m && j < n) {
            if (name.charAt(i) == typed.charAt(j)) {
                c = name.charAt(i);
                i++;
                j++;
            } else if (typed.charAt(j) == c) {
                j++;
            } else {
                return false;
            }
        }

        while (j < n) {
            if (typed.charAt(j) != c) {
                return false;
            }
            j++;
        }

        return i >= m;
    }

    public static void main(String[] args) {
        Solution s = new Solution(); // "pyplrz"
//        "ppyypllr"
        Assert.assertFalse(s.isLongPressedName("pyplrz", "ppyypllr"));
        Assert.assertFalse(s.isLongPressedName("saeed", "ssaaedd"));
        Assert.assertTrue(s.isLongPressedName("alex", "aaleex"));
        Assert.assertTrue(s.isLongPressedName("leelee", "lleeelee"));
        Assert.assertTrue(s.isLongPressedName("laiden", "laiden"));
    }
}
