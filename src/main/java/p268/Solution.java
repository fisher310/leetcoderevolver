package p268;

import org.junit.Assert;

class Solution {

    public int missingNumber(int[] nums) {
        int ans = 0;
        for (int j : nums) {
            ans ^= j;
        }

        for (int i = 0; i <= nums.length; i++) {
            ans ^= i;
        }

        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        Assert.assertEquals(2, s.missingNumber(new int[]{1,3,0}));
        Assert.assertEquals(8, s.missingNumber(new int[]{9,6,4,2,3,5,7,0,1}));
    }
}
