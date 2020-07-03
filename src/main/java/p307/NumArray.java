package p307;

class NumArray {

    BIT b;

    int[] nums;

    public NumArray(int[] nums) {
        this.nums = nums;
        b = new BIT(nums.length);
        for (int i = 0; i < nums.length; i++) {
            b.update(i + 1, nums[i]);
        }
    }

    public void update(int i, int val) {
        b.update(i + 1, val - nums[i]);
        nums[i] = val;
    }

    public int sumRange(int i, int j) {
        return b.sum(j + 1) - b.sum(i);
    }

    static class BIT {
        private int[] bit;

        public BIT(int n) {
            bit = new int[n + 1];
        }

        public void update(int i, int delta) {
            while (i < bit.length) {
                bit[i] += delta;
                i += lowbit(i);
            }
        }

        public int sum(int i) {
            int sum = 0;
            while (i > 0) {
                sum += bit[i];
                i -= lowbit(i);
            }
            return sum;
        }

        private int lowbit(int n) {
            return n & (-n);
        }
    }

    public static void main(String[] args) {
        NumArray numArray = new NumArray(new int[] {1, 3, 5});
        System.out.println(numArray.sumRange(0, 2));
        numArray.update(1, 2);
        System.out.println(numArray.sumRange(0, 2));
    }
}
