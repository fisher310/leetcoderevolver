package p667;

/**
 * @author lihailong
 * @since 2021/1/12 0012
 */
class Solution {

    public int[] constructArray(int n, int k) {

        int[] ans = new int[n];
        int l = 1, r = n;
        boolean left = true;
        int index = 0;
        while (k >= 1) {
            if (left) {
                ans[index] = l++;
            } else {
                ans[index] = r--;
            }
            left = !left;
            index++;
            k--;
        }

        if (ans[index > 0 ? index - 1 : 0] == (l > 1 ? l - 1 : 1)) {
            while (l <= r) {
                ans[index++] = l++;
            }
        } else {
            while (r >= l) {
                ans[index++] = r--;
            }
        }

        return ans;
    }
}
