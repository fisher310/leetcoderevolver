package common.tree;

public class FenwickTreeRangeQueryPointUpdate {

    final int N;

    private long[] tree;

    public FenwickTreeRangeQueryPointUpdate(int sz) {
        tree = new long[(N = sz + 1)];
    }

    public FenwickTreeRangeQueryPointUpdate(long[] values) {

        if (values == null) throw new IllegalArgumentException("Values array can not be null!");

        N = values.length + 1;

        tree = new long[N];

        System.arraycopy(values, 0, tree, 1, values.length);

        for (int i = 1; i < N; i++) {
            int parent = i + lsb(i);
            if (parent < N) tree[parent] += tree[i];
        }
    }

    private static int lsb(int i) {
        return i & -i;
    }

    public long prefixSum(int i) {
        long sum = 0L;
        i += 1;
        while (i != 0) {
            sum += tree[i];
            i &= ~lsb(i); // i -= lsb(i)
        }
        return sum;
    }

    public long sum(int left, int right) {
        if (right < left) throw new IllegalArgumentException("Make sure right >= left");
        return prefixSum(right) - prefixSum(left - 1);
    }

    public long get(int i) {
        return sum(i, i);
    }

    public void add(int i, long v) {
        while (i < N) {
            tree[i] += v;
            i += lsb(i);
        }
    }

    public void set(int i, long v) {
        i += 1;
        add(i, v - get(i));
    }

    @Override
    public String toString() {
        return java.util.Arrays.toString(tree);
    }

    public static void main(String[] args) {
        long[] arr = new long[] {1, 2, 3};

        FenwickTreeRangeQueryPointUpdate tree = new FenwickTreeRangeQueryPointUpdate(arr);

        System.out.println(tree);

        System.out.println(tree.prefixSum(1));
        System.out.println(tree.get(2));

        System.out.println(tree.sum(1,2));
        System.out.println(tree.sum(0,1));
    }
}
