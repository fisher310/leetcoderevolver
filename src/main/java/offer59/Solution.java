package offer59;

import org.junit.Assert;

import java.util.Deque;
import java.util.LinkedList;

class Solution {

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) return new int[0];

        int N = nums.length - k + 1;

        int[] res = new int[N];
        int j = 0;

        Deque<Integer> queue = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i >= k && queue.peek() == nums[i - k]) {
                queue.poll();
            }

            while (!queue.isEmpty() && queue.peekLast() < nums[i]) {
                queue.pollLast();
            }
            queue.offer(nums[i]);
            if (i >= k - 1) {
                res[j++] = queue.peek();
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        Assert.assertArrayEquals(
                new int[] {3, 3, 2, 5}, s.maxSlidingWindow(new int[] {1, 3, 1, 2, 0, 5}, 3));
        Assert.assertArrayEquals(
                new int[] {3, 3, 5, 5, 6, 7},
                s.maxSlidingWindow(new int[] {1, 3, -1, -3, 5, 3, 6, 7}, 3));
    }
}
