package p930;

/**
 * 0 1 组成的数组，子数组和是 S 的个数
 */
class Solution {

    public int numSubarraysWithSum(int[] A, int S) {

        int sum = A[0];
        int l = 0, r = 1;
        int n = A.length;
        int ans = 0;
        while (l < r) {
            if(sum < S && r < n) {
                r++;
                sum += A[r];
            } else {
                sum -= A[l];
                l++;
            }
            if (sum == S){
                ans ++;
            }
        }

        return ans;
    }
}
