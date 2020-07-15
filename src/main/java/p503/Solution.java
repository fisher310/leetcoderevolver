package p503;

import java.util.LinkedList;

class Solution {

    public int[] nextGreaterElements(int[] nums) {

        LinkedList<int[]> stack = new LinkedList<>();

        int len = nums.length;
        int n = 2 * len;
        int[] ans = new int[len];
        boolean[] visited = new boolean[len];
        for (int i = 0; i < n; i++) {
            int idx = i % len;
            while (!stack.isEmpty() && stack.peek()[1] < nums[idx]) {
                ans[stack.peek()[0]] = nums[idx];
                visited[stack.peek()[0]] = true;
                stack.pop();
            }
            if (visited[idx]) continue;
            stack.push(new int[] {idx, nums[idx]});
        }

        while (!stack.isEmpty()) {
            ans[stack.peek()[0]] = -1;
            stack.pop();
        }
        return ans;
    }
}
