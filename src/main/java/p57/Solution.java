package p57;

import java.util.LinkedList;

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {

        int idx = 0, n = intervals.length;

        LinkedList<int[]> list = new LinkedList<>();
        while (idx < n && intervals[idx][0] < newInterval[0])  {
            list.add(intervals[idx++]);
        }

        int[] interval;
        if (list.isEmpty() || list.getLast()[1] < newInterval[0]) {
            list.add(newInterval);
        } else {
            interval = list.removeLast();
            interval[1] = Math.max(interval[1], newInterval[1]);
            list.add(interval);
        }

        while (idx < n) {
            interval = intervals[idx++];
            int start = interval[0], end = interval[1];
            if (list.getLast()[1] < start) {
                list.add(interval);
            } else {
                int[] last = list.removeLast();
                last[1] = Math.max(last[1], end);
                list.add(last);
            }
        }

        return list.toArray(new int[list.size()][2]);
    }

}
