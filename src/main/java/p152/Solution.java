package p152;

import org.junit.Assert;

/** 乘积最大子数组 */
class Solution {
    public int maxProduct(int[] nums) {
//        int[] maxF = new int[nums.length];
//        int[] minF = new int[nums.length];
//
//        maxF[0] = nums[0];
//        minF[0] = nums[0];
//
//        for (int i = 1; i < nums.length; i++) {
//            maxF[i] = Math.max(maxF[i-1] * nums[i], Math.max(nums[i], minF[i-1] * nums[i]));
//            minF[i] = Math.min(minF[i-1] * nums[i], Math.min(nums[i], maxF[i-1] * nums[i]));
//        }
//        return Arrays.stream(maxF).max().getAsInt();
        int maxF = nums[0], minF = nums[0], ans=nums[0];
        for (int i = 1; i < nums.length; i++) {
            int mx = maxF, mn = minF;
            maxF = Math.max(mx* nums[i], Math.max(nums[i], mn* nums[i]));
            minF = Math.min(mn* nums[i], Math.min(nums[i], mx* nums[i]));
            ans = Math.max(ans, maxF);
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
//        System.out.println(s.maxProduct(new int[] {0, 2}));
//        System.out.println(s.maxProduct(new int[] {3, -1, 4}));
        Assert.assertEquals(12, s.maxProduct(new int[]{-4,-3, -2}));
    }
}
