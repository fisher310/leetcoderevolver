package p1550;

import org.junit.Assert;

class Solution {

    public boolean threeConsecutiveOdds(int[] arr) {

        int odds = 0;
        for (int i = 0; i < arr.length; i++) {
            if ((arr[i] & 1) == 1) {
                odds++;
                if (odds == 3) return true;
            } else {
                odds = 0;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        Assert.assertTrue(s.threeConsecutiveOdds(new int[]{1, 2, 34, 3, 4, 5, 7, 23, 12}));
        Assert.assertFalse(s.threeConsecutiveOdds(new int[]{2, 6, 4, 1}));
    }
}
