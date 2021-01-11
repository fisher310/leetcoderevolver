package p941;

import org.junit.Assert;

class Solution {

    public boolean validMountainArray(int[] A) {
        int n = A.length;
        int l = 0, r = n - 1;
        while (l < n && A[l] < A[l + 1]) l++;

        while (r > 0 && A[r - 1] > A[r]) r--;

        return l > 0 && r < n - 1 && l == r;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        Assert.assertTrue(s.validMountainArray(new int[] {0, 2, 3, 4, 5, 2, 1, 0}));
        Assert.assertFalse(s.validMountainArray(new int[] {0, 2, 3, 3, 5, 2, 1, 0}));
    }
}
