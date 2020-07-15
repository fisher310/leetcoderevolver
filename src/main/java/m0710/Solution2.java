package m0710;

import org.junit.Assert;

class Solution2 {

    public int shipWithinDays(int[] weights, int D) {
        if (null == weights || weights.length == 0)
            return 0;
        int l = weights[0], r = weights[0];
        for (int i = 1; i < weights.length; i++) {
            l = Math.max(l, weights[i]);
            r += weights[i];
        }

        while (l <= r) {
            int mid = l + (r - l) / 2;
            int days = split(weights, mid);

            if (days <= D) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return l;
    }

    private int split(int[] weights, int load) {
        int d = 0;
        int sum = 0;
        for (int i = 0; i < weights.length;) {
            int tmp = sum + weights[i];
            if (tmp > load) {
                d++;
                sum = 0;
            } else if (tmp == load) {
                d++;
                i++;
                sum = 0;
            } else {
                sum += weights[i];
                i++;
            }
        }
        if (sum > 0)
            d++;
        return d;
    }

    public static void main(String[] args) {
        Solution2 s = new Solution2();
        Assert.assertEquals(602, s.shipWithinDays(new int[] { 147, 73, 265, 305, 191, 152, 192, 293, 309, 292, 182, 157,
                381, 287, 73, 162, 313, 366, 346, 47 }, 10));
        Assert.assertEquals(160, s.shipWithinDays(new int[] { 10, 50, 100, 100, 50, 100, 100, 100 }, 5));
        Assert.assertEquals(6, s.shipWithinDays(new int[] { 3, 2, 2, 4, 1, 4 }, 3));
        Assert.assertEquals(15, s.shipWithinDays(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }, 5));

    }

}