package p1834;

import java.util.*;

/**
 * @author lihailong
 * @since 2021/04/20 14:19:47
 */
class Solution {

    public int[] getOrder(int[][] tasks) {

        int n = tasks.length;

        List<Task> all = new ArrayList<>(n);
        for (int i = 0; i < tasks.length; i++) {
            all.add(new Task(i, tasks[i][0], tasks[i][1]));
        }

        all.sort(Comparator.comparingInt(o -> o.enqueueTime));

        PriorityQueue<Task> queue =
                new PriorityQueue<>(
                        (t1, t2) ->
                                t1.processingTime == t2.processingTime
                                        ? t1.id - t2.id
                                        : t1.processingTime - t2.processingTime);
        long currentTime = 0;
        int[] ans = new int[tasks.length];
        int k = 0;
        for (int i = 0; i < n; i++) {
            if (queue.isEmpty()) {
                currentTime = Math.max(currentTime, all.get(k).enqueueTime);
            }
            while (k < n && all.get(k).enqueueTime <= currentTime) {
                queue.offer(all.get(k));
                k++;
            }

            Task t = queue.poll();
            ans[i] = t.id;
            currentTime += t.processingTime;
        }

        return ans;
    }

    private static class Task {
        private final int id;
        private final int enqueueTime;
        private final int processingTime;

        Task(int id, int enqueueTime, int processingTime) {
            this.id = id;
            this.enqueueTime = enqueueTime;
            this.processingTime = processingTime;
        }

        @Override
        public String toString() {
            return "{id:" + id + ", [" + enqueueTime + "," + processingTime + "]} \n";
        }
    }
}
