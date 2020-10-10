package p1589;

import org.junit.Assert;

import java.util.Arrays;

class Solution {

    public int maxSumRangeQuery(int[] nums, int[][] requests) {
        int[] indexes = new int[nums.length + 1];

        for (int i = 0; i < requests.length; i++) {
            indexes[requests[i][0]] += 1;
            indexes[requests[i][1] + 1] -= 1;
        }

        for (int i = 1; i < indexes.length; i++) {
            indexes[i] += indexes[i - 1];
        }

        Arrays.sort(indexes);
        Arrays.sort(nums);

        long ans = 0;
        for (int i = indexes.length - 1, j = nums.length - 1; i >= 0 && indexes[i] > 0; i--, j--) {
            ans = (ans + indexes[i] * nums[j]) % 1000000007;
        }
        return (int) ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        Assert.assertEquals(
                49,
                s.maxSumRangeQuery(
                        new int[] {1, 8, 5, 5, 2},
                        new int[][] {{4, 4}, {3, 4}, {4, 4}, {2, 4}, {0, 0}}));
        Assert.assertEquals(
                19, s.maxSumRangeQuery(new int[] {1, 2, 3, 4, 5}, new int[][] {{1, 3}, {0, 1}}));
        Assert.assertEquals(
                11, s.maxSumRangeQuery(new int[] {1, 2, 3, 4, 5, 6}, new int[][] {{0, 1}}));
    }
}
