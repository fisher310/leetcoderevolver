package p327;

import org.junit.Assert;

class Solution {

    public int countRangeSum(int[] nums, int lower, int upper) {

        //        FenwickTree ft = new FenwickTree(nums.length);
        //        for (int i = 0; i < nums.length; i++) {
        //            ft.update(i, nums[i]);
        //        }
        int n = nums.length;
        long[] sum = new long[n + 1];
        for (int i = 0; i < nums.length; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }
        return mergeSort(sum, new long[n + 1], 0, n, lower, upper);
    }

    private int mergeSort(long[] nums, long[] arr, int from, int to, int lower, int upper) {
        if (from >= to) return 0;
        int mid = from + (to - from) / 2;
        int res =
                mergeSort(nums, arr, from, mid, lower, upper)
                        + mergeSort(nums, arr, mid + 1, to, lower, upper);
        int rlow = mid + 1, rhigh = mid + 1;
        for (int i = from; i <= mid; i++) {
            while (rlow <= to && nums[rlow] - nums[i] < lower) {
                rlow++;
            }

            while (rhigh <= to && nums[rhigh] - nums[i] <= upper) {
                rhigh++;
            }
            res += rhigh - rlow;
        }
        merge(nums, arr, from, to);
        return res;
    }

    private void merge(long[] nums, long[] arr, int from, int to) {
        int mid = from + (to - from) / 2;
        int left = from, right = mid + 1;
        int idx = from;
        while (left <= mid && right <= to) {
            if (nums[left] < nums[right]) {
                arr[idx++] = nums[left++];
            } else {
                arr[idx++] = nums[right++];
            }
        }

        while (left <= mid) {
            arr[idx++] = nums[left++];
        }
        while (right <= to) {
            arr[idx++] = nums[right++];
        }
        System.arraycopy(arr, from, nums, from, to - from + 1);
    }

    private boolean isInRange(long val, int lower, int upper) {
        return lower <= val && val <= upper;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        Assert.assertEquals(3, s.countRangeSum(new int[] {-2, 5, -1}, -2, 2));
        Assert.assertEquals(
                3,
                s.countRangeSum(new int[] {-2147483647, 0, -2147483647, 2147483647}, -564, 3864));
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
