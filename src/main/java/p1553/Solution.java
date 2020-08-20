package p1553;

import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;

class Solution {


    Map<Integer, Integer> cache = new HashMap<>();

    public int minDays(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        if (cache.containsKey(n)) {
            return cache.get(n);
        }
        int ans = Integer.MAX_VALUE;
        ans = Math.min(ans, n % 2 + minDays(n / 2) + 1);
        ans = Math.min(ans, n % 3 + minDays(n / 3) + 1);
        cache.put(n, ans);
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        Assert.assertEquals(29, s.minDays(61455274));
//        Assert.assertEquals(4, s.minDays(10));
//        Assert.assertEquals(3, s.minDays(6));
//        Assert.assertEquals(1, s.minDays(1));
//        Assert.assertEquals(6, s.minDays(56));
    }

}
