package p739;

import java.util.LinkedList;

class Solution {

    public int[] dailyTemperatures(int[] T) {

        LinkedList<int[]> stack = new LinkedList<>();

        int[] ans = new int[T.length];
        for (int i = 0; i < T.length; i++) {
            while (!stack.isEmpty() && T[i] > stack.peek()[1]) {
                ans[stack.peek()[0]] = i - stack.peek()[0];
                stack.pop();
            }

            stack.push(new int[]{i, T[i]});
        }

        while (!stack.isEmpty()) {
            ans[stack.peek()[0]] = 0;
            stack.pop();
        }

        return ans;
    }
}
