package test;

import org.junit.Assert;

import java.util.*;

class Solution3 {

    public int[] avoidFlood(int[] rains) {
        int[] ans = new int[rains.length];

        TreeSet<Integer> treeSet = new TreeSet<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < rains.length; i++) {
            if (rains[i] == 0) {
                treeSet.add(i);
            } else {
                if (map.containsKey(rains[i])) {
                    // 如果已经下雨了
                    Integer ceiling = treeSet.ceiling(map.get(rains[i]));
                    if (!treeSet.isEmpty() && ceiling != null) {
                        // 安排抽空
                        treeSet.remove(ceiling);
                        ans[ceiling] = rains[i];
                    } else {
                        return new int[0];
                    }
                }
                map.put(rains[i], i);
                ans[i] = -1;
            }
        }

        for (int i = 0; i < ans.length; i++) {
            if (ans[i] == 0) ans[i] = 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution3 s = new Solution3();
        Assert.assertArrayEquals(
                new int[] {-1, 1, -1, -1, 2, -1, -1},
                s.avoidFlood(new int[] {1, 0, 2, 3, 0, 1, 2}));
        Assert.assertArrayEquals(
                new int[] {-1, 1, -1, 2, -1, -1}, s.avoidFlood(new int[] {1, 0, 2, 0, 2, 1}));
        Assert.assertArrayEquals(new int[] {}, s.avoidFlood(new int[] {0, 1, 1}));
        Assert.assertArrayEquals(new int[] {-1, 1, -1, 1}, s.avoidFlood(new int[] {1, 0, 2, 0}));
        System.out.println(Arrays.toString(s.avoidFlood(new int[] {1, 2, 3, 4})));
        Assert.assertArrayEquals(
                new int[] {-1, -1, 2, 1, -1, -1}, s.avoidFlood(new int[] {1, 2, 0, 0, 2, 1}));
        System.out.println(Arrays.toString(s.avoidFlood(new int[] {1, 2, 0, 1, 2})));
    }
}
