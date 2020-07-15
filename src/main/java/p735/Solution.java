package p735;

import org.junit.Assert;

import java.util.LinkedList;

class Solution {

    public int[] asteroidCollision(int[] asteroids) {

        LinkedList<Integer> stack = new LinkedList<>();

        outer:
        for (int i = 0; i < asteroids.length; i++) {
            if (asteroids[i] < 0) {
                if (stack.isEmpty()) {
                    stack.push(asteroids[i]);
                } else {
                    if (stack.peek() < 0) {
                        stack.push(asteroids[i]);
                        continue;
                    }
                    while (!stack.isEmpty()) {
                        if (stack.peek() < 0) {
                            stack.push(asteroids[i]);
                            continue outer;
                        }
                        if (stack.peek() < Math.abs(asteroids[i])) {
                            stack.pop();
                        } else if (stack.peek() == Math.abs(asteroids[i])) {
                            stack.pop();
                            continue outer;
                        } else {
                            break;
                        }
                    }
                    if (stack.isEmpty()) {
                        stack.push(asteroids[i]);
                    }
                }
            } else {
                stack.push(asteroids[i]);
            }
        }

        int[] res = new int[stack.size()];
        int i = 0;
        while (!stack.isEmpty()) {
            res[i++] = stack.pollLast();
        }

        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        Assert.assertArrayEquals(
                new int[] {-2, -2, -2}, s.asteroidCollision(new int[] {-2, -2, 1, -2}));
        Assert.assertArrayEquals(new int[] {5, 10}, s.asteroidCollision(new int[] {5, 10, -5}));
    }
}
