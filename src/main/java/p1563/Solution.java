package p1563;

import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;

class Solution {

    Map<Integer, Integer> cache = new HashMap<>();

    public int stoneGameV(int[] stoneValue) {

        return dfs(stoneValue, 0, stoneValue.length);
    }

    private int dfs(int[] stoneValue, int start, int end) {
        if (end - start <= 1) return 0;

        int key = start * 1000 + end;
        if (cache.containsKey(key)) {
            return cache.get(key);
        }

        int ans = Integer.MIN_VALUE;
        for (int i = start + 1; i < end; i++) {

            int left = 0, right = 0;

            for (int l = start; l < i; l++) {
                left += stoneValue[l];
            }

            for (int r = i; r < end; r++) {
                right += stoneValue[r];
            }

            if (left > right) {
                ans = Math.max(ans, dfs(stoneValue, i, end) + right);
            } else if (right > left) {
                ans = Math.max(ans, dfs(stoneValue, start, i) + left);
            } else {
                ans = Math.max(ans, Math.max(dfs(stoneValue, start, i) + left, dfs(stoneValue, i, end) + right));
            }

        }
        cache.put(key, ans);
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        Assert.assertEquals(18, s.stoneGameV(new int[]{6, 2, 3, 4, 4, 5}));
        Assert.assertEquals(28, s.stoneGameV(new int[]{7, 7, 7, 7, 7, 7, 7}));
        Assert.assertEquals(0, s.stoneGameV(new int[]{4}));
        long start = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            Assert.assertEquals(23163347, s.stoneGameV(new int[]{1, 1, 8, 27, 64, 125, 216, 343, 512, 729, 1000, 1331, 1728, 2197, 2744, 3375, 4096, 4913, 5832, 6859, 8000, 9261, 10648, 12167, 13824, 15625, 17576, 19683, 21952, 24389, 27000, 29791, 32768, 35937, 39304, 42875, 46656, 50653, 54872, 59319, 64000, 68921, 74088, 79507, 85184, 91125, 97336, 103823, 110592, 117649, 125000, 132651, 140608, 148877, 157464, 166375, 175616, 185193, 195112, 205379, 216000, 226981, 238328, 250047, 262144, 274625, 287496, 300763, 314432, 328509, 343000, 357911, 373248, 389017, 405224, 421875, 438976, 456533, 474552, 493039, 512000, 531441, 551368, 571787, 592704, 614125, 636056, 658503, 681472, 704969, 729000, 753571, 778688, 804357, 830584, 857375, 884736, 912673, 941192, 970299}));
        }
        System.out.println("duration: " + (System.currentTimeMillis() - start));
    }

}
