package p1385;

import org.junit.Assert;

class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {

        int ans = 0;
        outer:
        for (int i : arr1) {
            for (int j : arr2) {
                if (Math.abs(i - j) <= d) {
                    continue outer;
                }
            }
            ans++;
        }

        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        Assert.assertEquals(
                2,
                s.findTheDistanceValue(
                        new int[] {1, 4, 2, 3}, new int[] {-4, -3, 6, 10, 20, 30}, 3));
        Assert.assertEquals(
                2, s.findTheDistanceValue(new int[] {4, 5, 8}, new int[] {10, 9, 1, 8}, 2));
    }
}
