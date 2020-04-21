package p1248;

/** 统计「优美子数组」 */
class Solution {

    public int numberOfSubarrays(int[] nums, int k) {
        int n = nums.length;
        int[] cnt = new int[n+1];
        int odd = 0, ans = 0;
        cnt[0] = 1;
        for (int num : nums) {
            odd += num & 1;
            ans += odd >= k ? cnt[odd - k] : 0;
            cnt[odd] += 1;
        }

        return ans;
    }
}
