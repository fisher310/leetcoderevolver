package p696;

import org.junit.Assert;

class Solution {

    public int countBinarySubstrings(String s) {
        int ptr = 0, pre = 0, n = s.length(), ans = 0;

        while (ptr < n) {
            char c = s.charAt(ptr);
            int count = 0;
            while (ptr < n && s.charAt(ptr) == c) {
                count++;
                ptr++;
            }
            ans += Math.min(count, pre);
            pre = count;
        }

        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        Assert.assertEquals(6, s.countBinarySubstrings("00110011"));
    }
}
