package p566;

import java.util.Arrays;

/**
 * @author lihailong
 * @since 2020/12/16 0016
 */
class Solution {

    public int[][] matrixReshape(int[][] nums, int r, int c) {
        if (nums == null || nums.length == 0) return nums;
        int or = nums.length;
        int oc = nums[0].length;

        if (or * oc != r * c) return nums;

        int[][] m = new int[r][c];
        int count = 0;
        for (int[] num : nums) {
            for (int j = 0; j < oc; j++) {
                m[count / c][count % c] = num[j];
                count++;
            }
        }
        return m;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] m = s.matrixReshape(new int[][] {{1, 2}, {3, 4}}, 1, 4);
        for (int i = 0; i < m.length; i++) {
            System.out.println(Arrays.toString(m[i]));
        }
    }
}
