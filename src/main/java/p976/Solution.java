package p976;

import org.junit.Assert;

import java.util.Arrays;

class Solution {

    public int largestPerimeter(int[] A) {

        Arrays.sort(A);

        for (int i = A.length - 1; i > 1; i--) {
            if (A[i - 2] + A[i - 1] > A[i]) {
                return A[i] + A[i - 1] + A[i - 2];
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        Assert.assertEquals(5, s.largestPerimeter(new int[]{2, 1, 2}));
        Assert.assertEquals(0, s.largestPerimeter(new int[]{1, 2, 1}));
        Assert.assertEquals(10, s.largestPerimeter(new int[]{2, 3, 3, 4}));
        Assert.assertEquals(8, s.largestPerimeter(new int[]{3, 6, 2, 3}));
    }
}
