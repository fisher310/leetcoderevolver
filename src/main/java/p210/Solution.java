package p210;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/** 课程表二 */
class Solution {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
//        if (null == prerequisites || prerequisites.length == 0) return new int[] {};

        int[] degree = new int[numCourses];

        Node[] nodes = new Node[numCourses];

        for (int[] require : prerequisites) {
            int pre = require[1];
            int next = require[0];
            if (nodes[pre] == null) {
                nodes[pre] = new Node(pre);
            }
            nodes[pre].addNext(next);

            if (nodes[next] == null) {
                nodes[next] = new Node(next);
            }
            degree[next] += 1;
        }

        int[] ans = new int[numCourses];
        int cur = 0;
        Queue<Node> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (degree[i] == 0) {
                ans[cur++] = i;
                if (nodes[i] != null) {
                    queue.offer(nodes[i]);
                }
            }
        }

        while (!queue.isEmpty()) {
            Node n = queue.poll();
            for (int nx : n.next) {
                degree[nx] -= 1;
                if (degree[nx] == 0) {
                    ans[cur++] = nx;
                    if (nodes[nx] != null) {
                        queue.offer(nodes[nx]);
                    }
                }
            }
        }

        for (int i = 0; i < numCourses; i++) {
            if (degree[i] != 0) {
                return new int[] {};
            }
        }

        return ans;
    }

    private static class Node {
        int value;
        List<Integer> next;

        Node(int value) {
            this.value = value;
            this.next = new LinkedList<>();
        }

        void addNext(int val) {
            next.add(val);
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        //        int[] ans = s.findOrder(2, new int[][]{{1,0}});
        //        System.out.println(Arrays.toString(ans));

        int[] ans2 = s.findOrder(4, new int[][] {{1, 0}, {2, 0}, {3, 1}, {3, 2}});
        System.out.println(Arrays.toString(ans2));

        int[] ans3 = s.findOrder(1, new int[][]{});
        System.out.println(Arrays.toString(ans3));
    }
}
