package p1202;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author lihailong
 * @since 2021/1/11 0011
 */
class Solution {

    int[] ufd;
    int[] rank;

    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {

        int N = s.length();
        ufd = new int[N];
        rank = new int[N];
        for (int i = 0; i < N; i++) {
            ufd[i] = i;
            rank[i] = 1;
        }

        for (List<Integer> pair : pairs) {
            int l = pair.get(0);
            int r = pair.get(1);
            union(l, r);
        }

        Map<Integer, PriorityQueue<Character>> map = new HashMap<>();

        for (int i = 0; i < ufd.length; i++) {
            int root = find(i);
            // root
            PriorityQueue<Character> pq =
                    map.computeIfAbsent(root, (k) -> new PriorityQueue<>(Character::compare));
            pq.add(s.charAt(i));
            map.put(root, pq);
        }

        StringBuilder res = new StringBuilder();
        for (int i = 0; i < N; i++) {
            int root = find(i);
            res.append(map.get(root).poll());
        }

        return new String(res);
    }

    private boolean isConnected(int i, int j) {
        return find(i) == find(j);
    }

    private void union(int i, int j) {
        if (isConnected(i, j)) {
            return;
        }
        int pi = find(i);
        int pj = find(j);
        if (rank[pi] > rank[pj]) {
            ufd[pj] = pi;
            rank[pi] += rank[pj];
        } else {
            ufd[pi] = pj;
            rank[pj] += rank[pi];
        }
    }

    private int find(int i) {
        if (ufd[i] != i) {
            ufd[i] = find(ufd[i]);
        }
        return ufd[i];
    }
}
