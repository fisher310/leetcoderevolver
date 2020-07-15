package p494;

class Solution {

    private int target;
    private int ans = 0;

    public int findTargetSumWays(int[] nums, int S) {

        this.target = S;
        ans = 0;

        dfs(nums, 0, 0);
        return ans;
    }

    private void dfs(int[] nums, int sum, int idx) {
        if (idx == nums.length) {
            if (sum == target) ans++;
            return;
        }

        dfs(nums, sum - nums[idx], idx + 1);
        dfs(nums, sum + nums[idx], idx + 1);
    }
}
