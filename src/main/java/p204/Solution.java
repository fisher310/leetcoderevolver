package p204;

import java.util.Arrays;

/** 计数质数 */
public class Solution {

    public int countPrimes(int n) {

        int count = 0;
        for (int i = 2; i <= n; i++) {
            if (isPrime(i))
                count++;
        }

        return count;
    }

    private boolean isPrime(int n) {
        if (n <= 1) return false;

        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        boolean[] valid = new boolean[2];
        Arrays.fill(valid, true);

        Solution s = new Solution();
        int cnt = s.countPrimes(10);
        System.out.println(cnt);
    }
}
