package p973;

import java.util.Arrays;
import java.util.PriorityQueue;
class Solution {

    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<Point> heap = new PriorityQueue<>((o1, o2) -> Integer.compare(o2.dis, o1.dis));

        for (int i = 0; i < points.length; i++) {
            Point p = new Point(points[i][0], points[i][1]);
            if (heap.size() < K) {
                heap.offer(p);
            } else if (p.dis < heap.peek().dis) {
                heap.poll();
                heap.offer(p);
            }
        }

        int[][] ans = new int[K][2];
        int i = 0;
        while (!heap.isEmpty()) {
            Point p = heap.poll();
            ans[i++] = new int[]{p.x, p.y};
        }
        return ans;
    }

    private static class Point {
        int x;
        int y;
        int dis;
        Point(int _x, int _y) {
            x = _x;
            y = _y;
            dis = x * x + y * y;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] ans = s.kClosest(new int[][]{{3, 3}, {5, -1}, {-2, 4}}, 2);
        for (int[]  arr : ans) {
            System.out.println(Arrays.toString(arr));
        }
    }
}
