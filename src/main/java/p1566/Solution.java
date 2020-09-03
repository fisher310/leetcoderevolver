package p1566;

import org.junit.Assert;

class Solution {

    public boolean containsPattern(int[] arr, int m, int k) {
        // [0 - k)
        int j = 0, i = 0;
        for (i= 0; i <= arr.length - m * k; i++) {
            for (j = i + m; j < i + m * k; j++) {
                if (arr[j] != arr[j-m]) break;
            }
            if (j == i + m * k) return true;
        }

        return false;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        Assert.assertFalse(s.containsPattern(new int[]{1, 2}, 1, 2));
        Assert.assertTrue(s.containsPattern(new int[]{2, 2}, 1, 2));
        Assert.assertTrue(s.containsPattern(new int[]{1, 2, 4, 4, 4, 4}, 1, 3));
        Assert.assertTrue(s.containsPattern(new int[]{1, 2, 1, 2, 1, 1, 1, 3}, 2, 2));
        Assert.assertFalse(s.containsPattern(new int[]{1, 2, 1, 2, 1, 3}, 2, 3));
    }
}
