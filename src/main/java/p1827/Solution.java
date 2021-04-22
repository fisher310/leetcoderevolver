package p1827;

/**
 * @author lihailong
 * @since 2021/04/21 21:20:47
 */
class Solution {

    public int minOperations(int[] nums) {

        int ans = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= nums[i - 1]) {
                ans += nums[i - 1] + 1 - nums[i];
                nums[i] = nums[i - 1] + 1;
            }
        }

        return ans;
    }
}
