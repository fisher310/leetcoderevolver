package p540;

import org.junit.Assert;

class Solution {
    public int singleNonDuplicate(int[] nums) {
        int ans = 0;
        for (int n : nums) {
            ans ^= n;
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        Assert.assertEquals(2, s.singleNonDuplicate(new int[]{1, 1, 2, 3, 3, 4, 4}));
    }
}
