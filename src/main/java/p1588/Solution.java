package p1588;

import org.junit.Assert;

class Solution {
    public int sumOddLengthSubarrays(int[] arr) {
        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            int sum = arr[i];
            ans += sum;
            for (int j = i + 1; j < arr.length; j++) {
                sum += arr[j];
                if ((j - i) % 2 == 0) {
                    ans += sum;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        Assert.assertEquals(58, s.sumOddLengthSubarrays(new int[] {1, 4, 2, 5, 3}));
    }
}
