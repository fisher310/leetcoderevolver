package p1009;

import static org.junit.Assert.assertEquals;

public class Solution {
    public int bitwiseComplement(int n) {
        if (n == 0) return 1;
        n = ~n;
        int i = 0;
        while ((n & 0x80000000) == 0x80000000) {
            n = (n << 1);
            i++;
        }
        return n >>> i;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        assertEquals(5, s.bitwiseComplement(10));
    }
}