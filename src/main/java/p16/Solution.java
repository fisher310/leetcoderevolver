package p16;

import java.util.Arrays;

/**
 * 最接近的三数之和
 */
class Solution {
    public int threeSumClosest(int[] nums, int target) {

        Arrays.sort(nums);
        int ans = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length; i++) {
            int e = nums.length - 1;
            int s = i + 1;
            while (s < e) {
                int sum = nums[i] + nums[s] + nums[e];
                if (Math.abs(sum - target) < Math.abs(ans - target)) {
                    ans = sum;
                }
                if (sum < target) {
                    s++;
                } else if (sum > target) {
                    e--;
                } else {
                    return sum;
                }
            }
        }
        return ans;
    }

}
