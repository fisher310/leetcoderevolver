package m62;

class Solution {
    public int lastRemaining(int n, int m) {
        return f(n, m);
    }

    int f(int n, int m) {
        if (n == 1) {
            return 0;
        }
        int x = f(n - 1, m);
        return (x + m) % n;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int rem = s.lastRemaining(5, 3);
        System.out.println(rem);
    }
}
