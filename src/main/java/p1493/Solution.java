package p1493;

class Solution {

    public int longestSubarray(int[] nums) {

        int ans = 0;
        // 并查集  zeros=0 ones=0
        for (int i = 0; i < nums.length; i++) {
            int len = 0;
            int l = i - 1 ;
            int r = i + 1;
            while (l >= 0) {
                if (nums[l--] == 1) {
                    len ++;
                } else {
                    break;
                }
            }
            while (r <nums.length ) {
                if (nums[r++] == 1) {
                    len++;
                } else {
                    break;
                }
            }
            ans = Math.max(ans, len);

        }

        return ans;
    }
}
