package p628;

import java.util.Arrays;

/**
 * @author lihailong
 * @since 2020/12/16 0016
 */
class Solution {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);

        return Math.max(
                nums[nums.length - 1] * nums[nums.length - 2] * nums[nums.length - 3],
                nums[0] * nums[1] * nums[nums.length - 1]);
    }
}
