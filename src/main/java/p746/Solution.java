package p746;

import org.junit.Assert;

class Solution {

    public int minCostClimbingStairs(int[] cost) {
        int[] res = new int[cost.length];

        res[0] = cost[0];
        res[1] = cost[1];

        for (int i = 2; i < cost.length; i++) {
            res[i] = Math.min(res[i - 1], res[i - 2]) + cost[i];
        }
        return Math.min(res[cost.length - 1], res[cost.length - 2]);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        Assert.assertEquals(
                6, s.minCostClimbingStairs(new int[] {1, 100, 1, 1, 1, 100, 1, 1, 100, 1}));
        Assert.assertEquals(15, s.minCostClimbingStairs(new int[] {10, 15, 20}));
        Assert.assertEquals(1, s.minCostClimbingStairs(new int[] {1, 2}));
    }
}
