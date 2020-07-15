package p1496;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

class Solution {

    public boolean isPathCrossing(String path) {

        Set<Point> set = new HashSet<>(path.length());
        int x = 0, y = 0;
        for (int i = 0; i < path.length(); i++) {
            char r = path.charAt(i);

            if (r == 'N') {
                y -= 1;
            } else if (r == 'S') {
                y += 1;
            } else if (r == 'E') {
                x += 1;
            } else {
                y -= 1;
            }
            Point p = new Point(x, y);
            if (set.contains(p)) {
                return true;
            }
            set.add(p);
        }

        return false;
    }

    private static class Point {
        int x;
        int y;

        Point(int _x, int _y) {
            x = _x;
            y = _y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point node = (Point) o;
            return x == node.x && y == node.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}
