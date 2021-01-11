package p944;

import org.junit.Assert;

class Solution {

    public int minDeletionSize(String[] A) {
        int len = A[0].length();
        int ans = 0;
        for (int col = 0; col < len; col++) {
            for (int i = 1; i < A.length; i++) {
                if (A[i].charAt(col) < A[i - 1].charAt(col)) {
                    ans++;
                    break;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        Assert.assertEquals(1, s.minDeletionSize(new String[] {"cba", "daf", "ghi"}));
        Assert.assertEquals(0, s.minDeletionSize(new String[] {"a", "b"}));
        Assert.assertEquals(3, s.minDeletionSize(new String[] {"zyx", "wvu", "tsr"}));
    }
}
