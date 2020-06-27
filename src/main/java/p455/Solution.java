package p455;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 分发饼干
 */
class Solution {

    public int findContentChildren(int[] g, int[] s) {

        Arrays.sort(g);
        Arrays.sort(s);

        Set<Integer> assigned = new HashSet<>();
        int ans = 0;
        int j = 0;
        for (int i = 0; i < g.length; i++) {
            while ((j < s.length && s[j] < g[i]) || assigned.contains(j)) {
                // 分配sj 给 gi
                j++;

            }
            if (j == s.length) {
                break;
            }
            assigned.add(j);
            ans ++;
        }

        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.findContentChildren(new int[]{1,2,3}, new int[]{1,1}));
        System.out.println(s.findContentChildren(new int[]{1,2}, new int[]{1,2,3}));
    }
}
