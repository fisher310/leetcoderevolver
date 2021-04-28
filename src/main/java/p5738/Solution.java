package p5738;

/**
 * @author lihailong
 * @since 2021/04/25 20:22:50
 */
class Solution {

    public int sumBase(int n, int k) {
        int ans = 0;
        while (n > k) {
            ans += n % k;
            n = n / k;
        }

        return ans;
    }
}
