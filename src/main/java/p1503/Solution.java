package p1503;

import org.junit.Assert;

class Solution {
    public int getLastMoment(int n, int[] left, int[] right) {
        int ans = 0;
        for (int i = 0; i < left.length; i++) {
            ans = Math.max(ans, left[i]);
        }
        for (int j = 0; j < right.length; j++) {
            ans = Math.max(ans, n - right[j]);
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        Assert.assertEquals(4, s.getLastMoment(4, new int[] {4, 3}, new int[] {0, 1}));
        Assert.assertEquals(4, s.getLastMoment(4, new int[] {4, 3}, new int[] {0, 1}));
        Assert.assertEquals(
                7, s.getLastMoment(7, new int[] {}, new int[] {0, 1, 2, 3, 4, 5, 6, 7}));
    }
}
