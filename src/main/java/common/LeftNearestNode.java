package common;

import java.util.Arrays;
import java.util.LinkedList;

class LeftNearestNode {

    public int[] leftNearestNumber(int[] nums) {
        if (nums == null || nums.length == 0) return nums;

        LinkedList<int[]> stack = new LinkedList<>();

        int[] ans = new int[nums.length];
        for (int i = nums.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek()[1] > nums[i]) {
                ans[stack.peek()[0]] = nums[i];
                stack.pop();
            }
            stack.push(new int[] {i, nums[i]});
        }

        while (!stack.isEmpty()) {
            ans[stack.peek()[0]] = -1;
            stack.pop();
        }

        return ans;
    }

    public static void main(String[] args) {
        LeftNearestNode s = new LeftNearestNode();
        System.out.println(Arrays.toString(s.leftNearestNumber(new int[] {5, 7, 8, 6, 10})));
    }
}
