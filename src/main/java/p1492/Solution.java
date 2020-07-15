package p1492;

import org.junit.Assert;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public int kthFactor(int n, int k) {
        Set<Integer> set = new HashSet<>();
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                set.add(i);
                set.add(n / i);
            }
        }
        if (set.size() < k) {
            return -1;
        }
        Integer[] arr = set.toArray(new Integer[] {});

        Arrays.sort(arr);
        return arr[k - 1];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        Assert.assertEquals(3, s.kthFactor(12, 3));
    }
}
