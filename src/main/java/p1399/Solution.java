package p1399;

/**
 * @author lihailong
 * @since 2020/12/17 0017
 */
class Solution {

    public int countLargestGroup(int n) {

        int max = Integer.MIN_VALUE;
        int[] sum = new int[n + 1];
        int[] count = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i / 10] + i % 10;
            count[sum[i]]++;
            max = Math.max(max, count[sum[i]]);
        }

        int ans = 0;
        for (int x : count) {
            if (x == max) ans++;
        }

        return ans;
    }
}
