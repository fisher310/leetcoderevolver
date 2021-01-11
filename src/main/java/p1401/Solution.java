package p1401;

import org.junit.Assert;

/** 划分成9个区域 */
class Solution {
    public boolean checkOverlap(
            int radius, int x_center, int y_center, int x1, int y1, int x2, int y2) {

        if (x1 <= x_center && x_center <= x2 && y1 <= y_center && y_center <= y2) {
            return true;
        } else if (x_center < x1 && y_center > y2) {
            return dis(x_center, y_center, x1, y2) <= radius * radius;
        } else if (x1 <= x_center && x_center <= x2 && y_center > y2) {
            return Math.abs(y_center - y2) <= radius;
        } else if (x2 < x_center && y_center > y2) {
            return dis(x_center, y_center, x2, y2) <= radius * radius;
        } else if (x_center > x2 && y_center < y2 && y_center > y1) {
            return Math.abs(x_center - x2) <= radius;
        } else if (x_center > x2 && y_center < y1) {
            return dis(x_center, y_center, x2, y1) <= radius * radius;
        } else if (x_center > x1 && x_center < x2 && y_center < y1) {
            return Math.abs(y_center - y1) <= radius;
        } else if (x_center < x1 && y_center < y1) {
            return dis(x_center, y_center, x1, y1) <= radius * radius;
        } else {
            return Math.abs(x1 - x_center) <= radius;
        }
    }

    private int dis(int x1, int y1, int x2, int y2) {
        int dx = x2 - x1;
        int dy = y2 - y1;
        return dx * dx + dy * dy;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        Assert.assertTrue(s.checkOverlap(3, 4, 1, 3, 3, 8, 5));
        Assert.assertTrue(s.checkOverlap(1, 0, 0, 1, -1, 3, 1));
    }
}
