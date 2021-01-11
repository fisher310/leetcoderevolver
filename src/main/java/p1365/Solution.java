package p1365;

/**
 * 输入：nums = [8,1,2,2,3] <br>
 * 输出：[4,0,1,1,3]
 */
class Solution {

    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] cnt = new int[101];
        for (int i = 0; i < nums.length; i++) {
            cnt[nums[i]]++;
        }

        for (int i = 1; i <= 100; i++) {
            cnt[i] += cnt[i - 1];
        }

        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ans[i] = nums[i] == 0 ? 0 : cnt[nums[i] - 1];
        }
        return ans;
    }
}
