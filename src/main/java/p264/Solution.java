package p264;

import org.junit.Assert;

class Solution {
    public int nthUglyNumber(int n) {

//        Set<Long> visited = new HashSet<>();
//        PriorityQueue<Long> heap = new PriorityQueue<>();
//
//        heap.add(1L);
//        visited.add(1L);
//        int[] prime = new int[]{2,3,5};
//        long ans = 0;
//        for (int i = 0; i < n; i++) {
//
//            ans = heap.poll();
//            for (int j : prime) {
//                long k = ans * j;
//                if (!visited.contains(k)) {
//                    visited.add(k);
//                    heap.offer(k);
//                }
//            }
//        }
//        return (int) ans;

        int[] dp = new int[n + 1];

        dp[0] = 1;
        int ugly = 0, p2 = 0, p3 = 0, p5 = 0;
        for (int i = 1; i <= n; i++) {
            ugly = Math.min(Math.min(dp[p2] * 2, dp[p3] * 3), dp[p5] * 5);
            dp[i] = ugly;
            if (ugly == dp[p2] * 2) p2++;
            if (ugly == dp[p3] * 3) p3++;
            if (ugly == dp[p5] * 5) p5++;
        }

        return dp[n];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        Assert.assertEquals(4, s.nthUglyNumber(3));
    }
}
