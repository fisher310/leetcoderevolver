package p1037;

import org.junit.Assert;

class Solution {
    public boolean isBoomerang(int[][] points) {
//        int d12 = (points[0][0] - points[1][0]) * (points[0][0] - points[1][0])
//                + (points[0][1] - points[1][1]) * (points[0][1] - points[1][1]);
//
//        int d23 = (points[1][0] - points[2][0]) * (points[1][0] - points[2][0])
//                + (points[1][1] - points[2][1]) * (points[1][1] - points[2][1]);
//
//        int d13 = (points[0][0] - points[2][0]) * (points[0][0] - points[2][0])
//                + (points[0][1] - points[2][1]) * (points[0][1] - points[2][1]);

        return !((points[1][1] - points[0][1]) * (points[2][0] - points[1][0])
                == (points[2][1] - points[1][1]) * (points[1][0] - points[0][0]));
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        Assert.assertFalse(s.isBoomerang(new int[][]{{1, 1}, {2, 2}, {3, 3}}));
    }
}
