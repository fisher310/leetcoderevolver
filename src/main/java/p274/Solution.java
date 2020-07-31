package p274;

import org.junit.Assert;

import java.util.Arrays;

class Solution {

    public int hIndex(int[] citations) {

        int n = citations.length;
        Arrays.sort(citations);
        for (int i = 0; i < n; i++) {
            if (citations[i] >= (n - i)) {
                return n - i;
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        Assert.assertEquals(3, s.hIndex(new int[] {3, 0, 6, 1, 5}));
    }
}
