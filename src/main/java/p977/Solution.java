package p977;

import org.junit.Assert;

class Solution {

    public int[] sortedSquares(int[] A) {
        int[] arr = new int[A.length];
        for (int i = 0, j = A.length - 1, pos = A.length - 1; i <= j; ) {
            if (A[i] * A[i] > A[j] * A[j]) {
                arr[pos] = A[i] * A[i];
                i++;
            } else {
                arr[pos] = A[j] * A[j];
                j--;
            }
            pos--;
        }
        return arr;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        Assert.assertArrayEquals(
                new int[] {0, 1, 9, 16, 100}, s.sortedSquares(new int[] {-4, -1, 0, 3, 10}));
    }
}
