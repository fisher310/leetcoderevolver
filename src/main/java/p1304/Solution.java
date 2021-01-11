package p1304;

import java.util.Arrays;

class Solution {

    public int[] sumZero(int n) {

        int[] ans = new int[n];
        int i = 0;
        int k = 1;
        if (n % 2 == 1) {
            ans[i++] = 0;
        }
        for (; i < n; i += 2) {
            ans[i] = k;
            ans[i + 1] = -k;
            k++;
        }

        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] ans = s.sumZero(5);
        System.out.println(Arrays.toString(ans));
        System.out.println(Arrays.toString(s.sumZero(4)));
    }
}
