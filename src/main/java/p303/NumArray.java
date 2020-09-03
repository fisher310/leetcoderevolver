package p303;

import org.junit.Assert;

class NumArray {

    int[] sum;

    public NumArray(int[] nums) {
        sum = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }
    }

    // [i, j]
    public int sumRange(int i, int j) {
        return sum[j + 1] - sum[i];
    }

    public static void main(String[] args) {
        NumArray arr = new NumArray(new int[]{-2, 0, 3, -5, 2, -1});
        Assert.assertEquals(1, arr.sumRange(0, 2));
        Assert.assertEquals(-1, arr.sumRange(2, 5));
        Assert.assertEquals(-3, arr.sumRange(0, 5));
    }
}
