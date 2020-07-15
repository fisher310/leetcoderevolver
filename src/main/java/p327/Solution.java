package p327;

class Solution {

    public int countRangeSum(int[] nums, int lower, int upper) {

        FenwickTree ft = new FenwickTree(nums.length);
        for (int i = 0; i < nums.length; i++) {
            ft.update(i, nums[i]);
        }

        for (int i = 0; i < nums.length; i++)  {

        }

        return 0;
    }

    static class FenwickTree {

        int[] bit;

        FenwickTree(int n) {
            bit = new int[n + 1];
        }

        void update(int i, int delta) {
            while (i < bit.length) {
                bit[i] += delta;
                i += lowbit(i);
            }
        }

        int query(int i) {
            int sum = 0;
            while (i > 0) {
                sum += bit[i];
                i -= lowbit(i);
            }
            return sum;
        }

        int lowbit(int n) {
            return n & (-n);
        }
    }
}
