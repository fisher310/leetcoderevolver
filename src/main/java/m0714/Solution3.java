package m0714;

import java.util.Arrays;
import java.util.LinkedList;

class Solution3 {

    public int[] asteroidCollision(int[] asteroids) {

        LinkedList<Integer> stack = new LinkedList<>();

        for (int i = 0; i < asteroids.length; i++) {
            if (asteroids[i] > 0) {
                stack.push(asteroids[i]);
            } else if (asteroids[i] == 0) {
                continue;
            } else {
                if (stack.isEmpty() || stack.peek() < 0) {
                    stack.push(asteroids[i]);
                } else {
                    while (!stack.isEmpty()
                            && stack.peek() > 0
                            && stack.peek() < Math.abs(asteroids[i])) {
                        stack.pop();
                    }
                    if (stack.isEmpty() || stack.peek() < 0) {
                        stack.push(asteroids[i]);
                    } else if (stack.peek() == Math.abs(asteroids[i])) {
                        stack.pop();
                    }
                }
            }
        }

        int[] ans = new int[stack.size()];
        int i = 0;
        while (!stack.isEmpty()) {
            ans[i++] = stack.pollLast();
        }

        return ans;
    }

    public static void main(String[] args) {
        Solution3 s = new Solution3();
        System.out.println(Arrays.toString(s.asteroidCollision(new int[] {10, 2, -5})));
    }
}
