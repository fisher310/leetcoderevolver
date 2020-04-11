package p349;

import java.util.HashSet;
import java.util.Set;

/** 两个数组的交集 */
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) return new int[] {};
        Set<Integer> s1 = new HashSet<>();
        for (int n : nums1) {
            s1.add(n);
        }
        Set<Integer> ans = new HashSet<>(s1.size());
        for (int n : nums2) {
            if (s1.contains(n)) {
                ans.add(n);
            }
        }
        int[] res = new int[ans.size()];
        int i = 0;
        for (int n : ans) {
            res[i++] = n;
        }
        return res;
    }
}
