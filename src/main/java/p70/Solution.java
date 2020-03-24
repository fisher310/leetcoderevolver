package p70;

/**
 *
 */
class Solution {
    public int climbStairs(int n) {
        int[] climb = new int[n + 1];
        climb[0] = 1;
        climb[1] = 1;
        for (int i = 2; i <= n; i++) {
            climb[i] = climb[i - 1] + climb[i - 2];
        }
        return climb[n];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.climbStairs(3));
    }
}