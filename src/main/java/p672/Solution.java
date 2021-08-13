package p672;

import java.util.BitSet;
import java.util.HashSet;
import java.util.Set;
import org.junit.Assert;

class Solution {
    private Set<BitSet> ans;
    private int N;

    public int flipLights(int n, int presses) {
        ans = new HashSet<>();
        BitSet bs = new BitSet(n);
        N = n;
        bs.flip(0, N);

        doFlip(bs, presses);
        return ans.size();
    }

    private void doFlip(BitSet bs, int n) {
        if (n == 0) {
            ans.add(bs.get(0, N));
            return;
        }
        // all flip
        BitSet bs1 = bs.get(0, N);
        bs1.flip(0, N);
        doFlip(bs1, n - 1);

        BitSet bs2 = bs.get(0, N);
        for (int i = 1; i <= N; i++) {
            if (i % 2 == 0) {
                bs2.flip(i - 1);
            }
        }
        doFlip(bs2, n - 1);

        BitSet bs3 = bs.get(0, N);
        for (int i = 1; i <= N; i++) {
            if (i % 2 == 1) {
                bs3.flip(i - 1);
            }
        }
        doFlip(bs3, n - 1);

        BitSet bs4 = bs.get(0, N);
        for (int i = 0; i < N - 1; i += 3) {
            bs4.flip(i);
        }
        doFlip(bs4, n - 1);
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        
        Assert.assertEquals(8, s.flipLights(4, 10));
        Assert.assertEquals(1, s.flipLights(4, 20));
        Assert.assertEquals(4, s.flipLights(3, 1));
        Assert.assertEquals(3, s.flipLights(2, 1));
        Assert.assertEquals(1, s.flipLights(1, 0));
        Assert.assertEquals(2, s.flipLights(1, 1));
        System.out.println("ok");
    }
}
