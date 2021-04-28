package p5739;

import java.util.Arrays;

/**
 * @author lihailong
 * @since 2021/04/25 20:29:51
 */
class Solution {

    public int maxFrequency(int[] nums, int k) {

        int ans = 1;
        int j = 0;
        long a = 0;
        Arrays.sort(nums);

        for (int i = 1; i < nums.length; i++) {
            a += ((long) nums[i] - nums[i - 1]) * (i - j);
            while (a > k) {
                a -= nums[i] - nums[j];
                j++;
            }

            ans = Math.max(ans, i - j + 1);
        }

        return ans;
    }
}
