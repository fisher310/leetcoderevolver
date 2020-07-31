package p1004;

import org.junit.Assert;

class Solution {

    public int longestOnes(int[] A, int K) {
        int l = 0;
        int r = 0;
        int zeros = 0;
        int ones = 0;
        int ans = 0;
        while (r < A.length) {
            if (A[r] == 0) {
                zeros++;
            } else if (A[r] == 1) {
                ones++;
                ans = Math.max(ans, Math.min(zeros + ones, ones + K));
            }

            while (zeros > K) {
                if (A[l] == 1) {
                    ones--;
                } else {
                    zeros--;
                }
                l++;
            }
            r++;
        }

        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        Assert.assertEquals(
                25,
                s.longestOnes(
                        new int[] {
                            1, 0, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 1, 0, 1,
                            1, 1, 1, 1, 1, 0, 1, 0, 1, 0, 0, 1, 1, 0, 1, 1
                        },
                        8));
        System.out.println(s.longestOnes(new int[] {1, 1, 1, 0, 0, 0, 1, 1, 1, 1}, 0));
        System.out.println(s.longestOnes(new int[] {0}, 0));
        System.out.println(
                s.longestOnes(
                        new int[] {0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1}, 3));
        System.out.println(s.longestOnes(new int[] {1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0}, 2));
    }
}
