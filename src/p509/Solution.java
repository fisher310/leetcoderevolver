package p509;

class Solution {
    public int fib(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int a1 = 0;
        int a2 = 1;

        for (int i = 2; i <= n; i++) {
            int temp = a2;
            a2 = a1 + a2;
            a1 = temp;
        }
        return a2;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.fib(4));
    }
}
