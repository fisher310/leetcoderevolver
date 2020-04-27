package p480;

import java.util.Arrays;
import java.util.PriorityQueue;

/** 滑动窗口中位数 */
class Solution {
    PriorityQueue<Long> lo;
    PriorityQueue<Long> hi;

    public double[] medianSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) return new double[0];

        lo = new PriorityQueue<>((o1, o2) -> Long.compare(o2, o1));
        hi = new PriorityQueue<>();

        double[] ans = new double[nums.length - k + 1];
        int l = 0, r = 0;
        while (r < k) {
            add(nums[r]);
            r++;
        }

        ans[0] = getMedian();
        int i = 1;
        while (r < nums.length) {
            remove(nums[l++]);
            add(nums[r++]);
            ans[i++] = getMedian();
        }

        return ans;
    }

    private void add(long num) {
        lo.offer(num);
        Long n1 = lo.poll();
        if (n1 != null) {
            hi.offer(n1);
        }

        if (hi.size() > lo.size()) {
            lo.offer(hi.poll());
        }
    }

    private void remove(long num) {
        long l = lo.peek();
        if (num <= l) {
            lo.remove(num);
        } else {
            hi.remove(num);
        }
        if (lo.size() < hi.size()) {
            lo.offer(hi.poll());
        }
    }

    private double getMedian() {
        if (lo.size() > hi.size()) {
            return lo.peek();
        } else {
            return (lo.peek() + hi.peek()) * 0.5;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        double[] ans = s.medianSlidingWindow(new int[] {1, 3, -1, -3, 5, 3, 6, 7}, 3);
        System.out.println(Arrays.toString(ans));
        ans = s.medianSlidingWindow(new int[] {2147483647, 2147483647}, 2);
        System.out.println(Arrays.toString(ans));
    }
}
