package p841;

import java.util.*;

class Solution {

    int N;

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {

        N = rooms.size();
        return dfs(rooms, 0, new HashSet<>());
    }

    private boolean dfs(List<List<Integer>> rooms, int room, Set<Integer> visited) {
        visited.add(room);
        if (visited.size() == N)
            return true;
        List<Integer> keys = rooms.get(room);
        for (int i = 0; i < keys.size(); i++) {
            if (!visited.contains(keys.get(i))) {
                if (dfs(rooms, keys.get(i), visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        List<List<Integer>> rooms = new ArrayList<>();
        rooms.add(Arrays.asList(1, 3));
        rooms.add(Arrays.asList(3, 0, 1));
        rooms.add(Arrays.asList(2));
        rooms.add(Arrays.asList(0));
        System.out.println(s.canVisitAllRooms(rooms));
    }

}