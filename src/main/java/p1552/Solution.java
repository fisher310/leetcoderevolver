package p1552;

import org.junit.Assert;

import java.util.Arrays;

class Solution {

    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);

        int l = 1;
        int r = position[position.length - 1] - position[0];
        if (m == 2) return r;

        while (l < r) {
            int mid = l + (r - l) / 2;
            if (check(position, m, mid)) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }

        return l - 1;
    }


    boolean check(int[] position, int m, int force) {

        m -= 1;
        int prePos = position[0];
        for (int i = 1; i < position.length; i++) {
            if (position[i] - prePos >= force) {
                m -= 1;
                if (m == 0) return true;
                prePos = position[i];
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        Assert.assertEquals(4, s.maxDistance(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 3));
        Assert.assertEquals(3, s.maxDistance(new int[]{1, 2, 3, 4, 7}, 3));
        Assert.assertEquals(999999999, s.maxDistance(new int[]{5, 4, 3, 2, 1, 1000000000}, 2));
    }
}
