package p207;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/** 课程表 */
class Solution {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (null == prerequisites || prerequisites.length == 0) return true;
        // 入度
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
            // 入度加1
            degree[next] += 1;
        }

        Queue<Node> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (degree[i] == 0 && nodes[i] != null) {
                queue.offer(nodes[i]);
            }
        }

        while (!queue.isEmpty()) {
            Node n = queue.poll();
            for (int next : n.next) {
                degree[next] -= 1;
                if (degree[next] == 0) {
                    if (nodes[next] != null) {
                        queue.offer(nodes[next]);
                    }
                }
            }
        }

        for (int i = 0; i < numCourses; i++) {
            if (degree[i] != 0) {
                return false;
            }
        }
        return true;
    }

    private static class Node {
        int course;
        List<Integer> next;

        Node(int course) {
            this.course = course;
            this.next = new LinkedList<>();
        }

        void addNext(int course) {
            this.next.add(course);
        }
    }
}
