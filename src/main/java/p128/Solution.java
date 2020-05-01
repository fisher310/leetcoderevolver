package p128;

import java.util.HashMap;
import java.util.Map;

/**
 * 最长连续序列
 */
class Solution {
    // 并查集，存储 key, key.parent
    Map<Integer, Integer> ufd;
    // 存储并查集中的数量 leader, size(leader)
    Map<Integer, Integer> count;

    public int longestConsecutive(int[] nums) {
        if (null == nums || nums.length == 0) return 0;

        ufd = new HashMap<>(nums.length);
        count = new HashMap<>(nums.length);

        for (int n : nums) {
            ufd.put(n, n);
            count.put(n, 1);
        }

        int ans = 1;

        for (int n : nums) {
            if (n != Integer.MAX_VALUE && count.containsKey(n + 1)) {
                ans = Math.max(ans, union(n, n + 1));
            }
        }
        return ans;
    }

    private int find(int p) {
        if (p != ufd.get(p)) {
            ufd.put(p, find(ufd.get(p)));
        }
        return ufd.get(p);
    }

    private int union(int p, int q) {
        int fp = find(p);
        int fq = find(q);
        if (fp != fq) {
            ufd.put(fq, fp);
            count.put(fp, count.get(fp) + count.get(fq));
        }
        return count.get(fp);
    }
}
