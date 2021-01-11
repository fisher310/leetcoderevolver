package p522;

import org.junit.Assert;

class Solution {

    public int findLUSlength(String[] strs) {
        int res = -1;
        outer:
        for (int i = 0; i < strs.length; i++) {
            for (int j = 0; j < strs.length; j++) {
                if (i == j) continue;
                if (isSubsequence(strs[i], strs[j])) continue outer;
            }
            res = Math.max(res, strs[i].length());
        }
        return res;
    }

    private boolean isSubsequence(String x, String y) {
        int j = 0;
        for (int i = 0; i < y.length() && j < x.length(); i++) {
            if (y.charAt(i) == x.charAt(j)) j++;
        }
        return j == x.length();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        Assert.assertEquals(2, s.findLUSlength(new String[] {"aabbcc", "aabbcc", "cb"}));
    }
}
