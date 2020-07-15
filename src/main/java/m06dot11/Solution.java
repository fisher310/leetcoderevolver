package m06dot11;

import java.util.Arrays;

class Solution {
    public int[] divingBoard(int shorter, int longer, int k) {
        if (k == 0) return new int[0];
        if (shorter == longer) {
            return new int[] {shorter * k};
        }

        int[] ans = new int[k + 1];
        for (int i = 0; i <= k; i++) {
            ans[i]= longer * i + shorter * (k - i);
        }

        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.divingBoard(1, 2, 3)));
        System.out.println(Arrays.toString(s.divingBoard(1, 1, 10000)));
    }
}
