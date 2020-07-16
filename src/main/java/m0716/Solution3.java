package m0716;

import java.util.Arrays;
import java.util.LinkedList;

class Solution3 {
    public int[] maxSlidingWindow(int[] nums, int k) {

        int[] ans = new int[nums.length - k + 1];

        LinkedList<Integer> queue = new LinkedList<>();
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i >= k && nums[i - k] == queue.peek()) {
                queue.poll();
            }
            // while (!queue.isEmpty() && (nums[i] > queue.peek())) {
            // queue.poll();
            // }
            while (!queue.isEmpty() && (nums[i] > queue.peekLast())) {
                queue.pollLast();
            }
            queue.offer(nums[i]);
            if (i >= k - 1) {
                ans[j++] = queue.peek();
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution3 s = new Solution3();
        System.out.println(Arrays.toString(s.maxSlidingWindow(new int[] { 1, 3, 1, 2, 0, 5 }, 3)));
        System.out.println(Arrays.toString(s.maxSlidingWindow(new int[] { 1, 3, -1, -3, 5, 3, 6, 7 }, 3)));
    }

}