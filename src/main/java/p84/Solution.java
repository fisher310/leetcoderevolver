package p84;

import java.util.LinkedList;

/** 柱状图中最大的矩形 */
class Solution {
    public int largestRectangleArea(int[] heights) {

        int max = 0;
        LinkedList<Integer> leftStack = new LinkedList<>();
        LinkedList<Integer> rightStack = new LinkedList<>();

        int left = 0, right = heights.length -1;

        while (left <= right) {

        }
        return max;
    }

    private int min(int[] array, int start, int end) {
        int min = array[start];
        for (int i = start + 1; i <= end; i++) {
            if (min > array[i]) {
                min = array[i];
            }
        }
        return min;
    }
}
