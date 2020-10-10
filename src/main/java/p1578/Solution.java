package p1578;

import org.junit.Assert;

class Solution {

    public int minCost(String s, int[] cost) {
        char[] ch = s.toCharArray();

        int ans = 0;
        int p1 = 0, p2 = 1;
        while (p1 < ch.length && p2 < ch.length) {
            if (ch[p1] != ch[p2]) {
                p1 = p2;
                p2++;
            } else {
                if (cost[p1] < cost[p2]) {
                    ans += cost[p1];
                    p1 = p2;
                } else {
                    ans += cost[p2];
                }
                p2++;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        Assert.assertEquals(23, s.minCost("bbbaaa", new int[] {4, 9, 3, 8, 8, 9}));
        Assert.assertEquals(3, s.minCost("abaac", new int[] {1, 2, 3, 4, 5}));
    }
}
