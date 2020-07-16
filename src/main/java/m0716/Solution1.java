package m0716;

import java.util.LinkedList;

class Solution1 {

    public int balancedStringSplit(String s) {

        LinkedList<Character> stack = new LinkedList<>();
        int l = 0;
        int r = 0;
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'L') {
                l ++;
            } else {
                r ++;
            }

            if (l == r) {
                ans ++;
                l = r = 0;
            }

        }

        return ans;
    }

    public static void main(String[] args) {
        Solution1 s = new Solution1();
        System.out.println(s.balancedStringSplit("RLRRLLRLRL"));
        System.out.println(s.balancedStringSplit("RLLLLRRRLR"));
    }
}