package p1385;

import org.junit.Assert;

import java.util.TreeSet;

class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {

        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int n : arr2) {
            treeSet.add(n);
        }

        int ans = 0;
        for (int n : arr1) {
            Integer f = treeSet.floor(n);
            Integer c = treeSet.ceiling(n);
            if (f != null && c != null) {
                if (Math.abs(f - n) > d && Math.abs(c - n) > d) ans++;
            } else if (f != null) {
                if (Math.abs(f - n) > d) ans++;
            } else if (c != null) {
                if (Math.abs(c - n) > d) ans++;
            }
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
