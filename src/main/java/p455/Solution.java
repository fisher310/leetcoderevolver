package p455;

import java.util.Arrays;

/**
 * 分发饼干
 */
class Solution {

    public int findContentChildren(int[] g, int[] s) {

        Arrays.sort(g);
        Arrays.sort(s);

        int ans = 0;
        int i = g.length - 1;
        int j = s.length - 1;
        while (i >= 0 && j >= 0) {
            if (s[j] >= g[i]) {
                j--;
                ans++;

            }
            i--;
        }

        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.findContentChildren(new int[]{1,2,3}, new int[]{1,1}));
        System.out.println(s.findContentChildren(new int[]{1,2}, new int[]{1,2,3}));
    }
}
