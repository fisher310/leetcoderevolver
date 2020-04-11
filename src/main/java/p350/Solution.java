package p350;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** 两个数组的交集 II */
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> m1 = new HashMap<>();
        for (int n : nums1) {
            m1.put(n, m1.getOrDefault(n, 0) + 1);
        }

        List<Integer> list = new ArrayList<>();
        for (int n : nums2) {
            int cnt = m1.getOrDefault(n, 0);
            if (cnt > 0) {
                list.add(n);
                m1.put(n, cnt - 1);
            }
        }

        int[] res = new int[list.size()];
        int i = 0;
        for (int n : list) {
            res[i++] = n;
        }

        return res;
    }
}
