package p1606;

import java.util.*;
import java.util.stream.Collectors;

class Solution {

    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {

        PriorityQueue<Server> worker = new PriorityQueue<>(Comparator.comparingInt(o -> o.end));
        TreeMap<Integer, Server> idle = new TreeMap<>();
        for (int i = 0; i < k; i++) {
            idle.put(i, new Server(i, 0));
        }
        for (int i = 0; i < arrival.length; i++) {
            while (!worker.isEmpty() && worker.peek().end <= arrival[i]) {
                Server server = worker.poll();
                idle.put(server.id, server);
            }
            int s = i % k;
            Integer id = idle.ceilingKey(s);
            if (id != null) {
                Server w = idle.remove(id);
                w.count++;
                w.end = arrival[i] + load[i];
                worker.offer(w);
            } else if (!idle.isEmpty()) {
                Server w = idle.remove(idle.firstKey());
                w.count++;
                w.end = arrival[i] + load[i];
                worker.offer(w);
            }
        }

        while (!worker.isEmpty()) {
            Server s = worker.poll();
            idle.put(s.id, s);
        }

        List<Server> list =
                idle.values().stream()
                        .sorted((o1, o2) -> o2.count - o1.count)
                        .collect(Collectors.toList());
        List<Integer> ans = new ArrayList<>();
        int max = 0;
        for (Server s : list) {
            if (s.count >= max) {
                max = s.count;
                ans.add(s.id);
            }
        }
        return ans;
    }

    private static class Server {
        int id;
        int end;
        int count;

        Server(int _id, int _end) {
            this.id = _id;
            this.end = _end;
            this.count = 0;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(
                s.busiestServers(3, new int[] {1, 2, 3, 4, 5}, new int[] {5, 2, 3, 3, 3}));
        System.out.println(s.busiestServers(3, new int[] {1, 2, 3, 4}, new int[] {1, 2, 1, 2}));
        System.out.println(s.busiestServers(3, new int[] {1, 2, 3}, new int[] {10, 12, 11}));
        System.out.println(
                s.busiestServers(
                        3, new int[] {1, 2, 3, 4, 8, 9, 10}, new int[] {5, 2, 10, 3, 1, 2, 2}));
        System.out.println(s.busiestServers(1, new int[] {1}, new int[] {1}));
    }
}
