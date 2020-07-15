package p84;

import org.junit.Assert;

/** 柱状图中最大的矩形 */
class Solution {
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) return 0;
        return solve(heights, 0, heights.length - 1);
    }

    private int solve(int[] heights, int left, int right) {

        if (left == right) {
            return heights[left];
        }

        int mid = left + (right - left) / 2;

        int res = Math.max(solve(heights, left, mid), solve(heights, mid + 1, right));

        int lo = mid, hi = mid + 1;

        int height = Math.min(heights[lo], heights[hi]);
        res = Math.max(res, height * 2);

        while (lo > left || hi < right) {
            if (hi < right && (lo == left || heights[hi + 1] > heights[lo - 1])) {
                hi++;
                height = Math.min(height, heights[hi]);
            } else {
                lo--;
                height = Math.min(height, heights[lo]);
            }

            res = Math.max(res, (hi - lo + 1) * height);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        Assert.assertEquals(18, s.largestRectangleArea(new int[] { 2, 3, 5, 9, 1, 5, 7, 3, 2, 9, 11 }));
        System.out.println(s.largestRectangleArea(new int[] { 2, 1, 5, 6, 3, 2 }));
    }
}
