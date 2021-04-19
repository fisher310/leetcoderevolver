package p461;

/**
 * @author lihailong
 * @since 2021/04/13 19:12:46
 */
class Solution {
    public int hammingDistance(int x, int y) {
        int n = x ^ y;
        int ans = 0;
        while (n != 0) {
            n &= (n - 1);
            ans++;
        }

        return ans;
    }
}
