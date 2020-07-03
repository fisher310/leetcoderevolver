package common.tree;

/** */
class BinaryIndexTree {

    private final int[] bit;

    public BinaryIndexTree(int n ) {
        bit = new int[n + 1];
    }

    public void update(int i, int delta) {
        for (int j = i; j < bit.length; j += lowbit(j)) {
            bit[j] += delta;
        }
    }

    public int query(int k) {
        int ans = 0;
        for (int i = k; i > 0; i -= lowbit(i)) {
            ans += bit[i];
        }
        return ans;
    }

    private int lowbit(int n) {
        return n & (-n);
    }
}
