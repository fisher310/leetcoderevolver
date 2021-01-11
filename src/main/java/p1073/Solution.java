package p1073;

import org.junit.Assert;

class Solution {

    public int[] addNegabinary(int[] arr1, int[] arr2) {
        int len1 = arr1.length, len2 = arr2.length;

        int rem = 0;
        int[] res = new int[Math.max(len1, len2) + 2];
        int k = 0, i = len1 - 1, j = len2 - 1;
        for (; i >= 0 || j >= 0; i--, j--) {
            int s = (i >= 0 ? arr1[i] : 0) + (j >= 0 ? arr2[j] : 0) + rem;
            if (s == 2) {
                rem = -1;
                res[k++] = 0;
            } else if (s == 1) {
                rem = 0;
                res[k++] = 1;
            } else if (s == 0) {
                rem = 0;
                res[k++] = 0;
            } else if (s == -1) {
                rem = 1;
                res[k++] = 1;
            } else if (s == 3) {
                rem = -1;
                res[k++] = 1;
            }
        }

        if (rem == -1) {
            res[k++] = 1;
            res[k++] = 1;
        }

        while (k > 0 && res[k - 1] == 0) k--;
        if (k == 0) return new int[] {0};
        int[] ans = new int[k];
        int n = 0;
        for (int m = k - 1; m >= 0; m--) {
            ans[n++] = res[m];
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        Assert.assertArrayEquals(
                new int[] {1, 0, 0, 0, 0},
                s.addNegabinary(new int[] {1, 1, 1, 1, 1}, new int[] {1, 0, 1}));
        Assert.assertArrayEquals(
                new int[] {1, 1, 0, 1, 0},
                s.addNegabinary(new int[] {1, 1, 1}, new int[] {1, 1, 1}));
        Assert.assertArrayEquals(new int[] {0}, s.addNegabinary(new int[] {1, 1}, new int[] {1}));
        Assert.assertArrayEquals(
                new int[] {1, 1, 0, 1, 0}, s.addNegabinary(new int[] {1}, new int[] {1, 0, 1}));
        Assert.assertArrayEquals(
                new int[] {1, 1, 1, 1, 0},
                s.addNegabinary(new int[] {1, 0, 1}, new int[] {1, 0, 1}));
    }
}
