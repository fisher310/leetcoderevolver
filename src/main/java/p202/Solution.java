package p202;

import java.util.HashSet;
import java.util.Set;

/** 快乐数 */
class Solution {

    public boolean isHappy(int n) {
        if (n == 1) return true;
        Set<Integer> set = new HashSet<>();
        while (n != 1) {
            n = sum(n);
            if (set.contains(n)) return false;
            set.add(n);
        }
        return true;
    }

    private int sum(int n) {
        int s = 0;
        while (n > 0) {
            int mod = n % 10;
            s += mod * mod;
            n /= 10;
        }

        return s;
    }
}
