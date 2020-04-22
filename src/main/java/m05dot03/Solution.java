package m05dot03;

/** 翻转数位 */
class Solution {
    public int reverseBits(int num) {

        int ans = 0, left = 0, right = 0;

        while (num != 0) {
            if ((num & 1) == 1) {
                right++;
            } else {
                ans = Math.max(left + right + 1, ans);
                left = right;
                right = 0;
            }
            num = num >> 1;
        }

        return Math.max(left + right + 1, ans);
    }
}
