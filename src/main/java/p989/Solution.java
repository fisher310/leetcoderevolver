package p989;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public List<Integer> addToArrayForm(int[] A, int K) {

        List<Integer> ans = new ArrayList<>();
        int l1 = A.length - 1;
        int shift = 0;
        while (l1 >= 0) {
            int a = A[l1];
            int b = K % 10;
            ans.add((a + K % 10 + shift) % 10);
            shift = (a + K % 10 + shift) / 10;
            K /= 10;
            l1--;
        }
        while (K > 0) {
            ans.add((K % 10 + shift) % 10);
            shift = (K % 10 + shift) / 10;
            K /= 10;
        }
        if (shift > 0) {
            ans.add(shift);
        }
        Collections.reverse(ans);
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.addToArrayForm(new int[] {0}, 23));
    }
}
