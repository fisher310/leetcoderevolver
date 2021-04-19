package p238;

import java.util.Arrays;

/**
 * @author lihailong
 * @since 2021/04/19 13:41:41
 */
class Solution {

    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;

        int[] L = new int[n];
        int[] R = new int[n];

        L[0] = 1;
        for (int i = 1; i < n; i++) {
            L[i] = L[i - 1] * nums[i - 1];
        }

        R[n - 1] = 1;
        for (int j = n - 2; j >= 0; j--) {
            R[j] = R[j + 1] * nums[j + 1];
        }

        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = L[i] * R[i];
        }

        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.productExceptSelf(new int[]{1, 2, 3, 4})));
    }
}
