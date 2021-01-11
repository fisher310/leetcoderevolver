package p1539;

import org.junit.Assert;

class Solution {
    public int findKthPositive(int[] arr, int k) {
        boolean[] cache = new boolean[1001];
        for (int n : arr) {
            cache[n] = true;
        }

        int t = 0;
        for (int i = 1; i <= 1000; i++) {
            if (!cache[i]) {
                t++;
                if (t == k) return i;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        Assert.assertEquals(9, s.findKthPositive(new int[]{2, 3, 4, 7, 11}, 5));
        Assert.assertEquals(6, s.findKthPositive(new int[]{1, 2, 3, 4}, 2));
    }
}
