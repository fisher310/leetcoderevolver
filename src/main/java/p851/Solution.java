package p851;

import java.util.*;

/**
 * @author lihailong
 * @since 2021/1/4 0004
 */
class Solution {

    public int[] loudAndRich(int[][] richer, int[] quiet) {

        int N = quiet.length;
        if (N == 0) return new int[0];

        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] r : richer) {
            List<Integer> br = map.getOrDefault(r[1], new ArrayList<>());
            br.add(r[0]);
            map.put(r[1], br);
        }

        int[] ans = new int[N];
        for (int i = 0; i < N; i++) {
            ans[i] = i;
        }

        for (int i = 0; i < ans.length; i++) {
            if (map.containsKey(i)) {

                Queue<Integer> q = new LinkedList<>(map.get(i));
                Set<Integer> visited = new HashSet<>(map.get(i));
                while (!q.isEmpty()) {
                    int curr = q.poll();
                    if (quiet[ans[i]] > quiet[curr]) {
                        ans[i] = curr;
                    }
                    if (map.containsKey(curr)) {
                        List<Integer> ns = map.get(curr);
                        for (int n : ns) {
                            if (!visited.contains(n)) {
                                q.offer(n);
                                visited.add(n);
                            }
                        }
                    }
                }
            }
        }

        return ans;
    }
}
