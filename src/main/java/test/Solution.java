package test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

class Solution {

    public List<List<Integer>> groupThePeople(int[] groupSizes) {

        List<Integer> group;
        List<List<Integer>> ans = new ArrayList<>();
        TreeMap<Integer, List<Integer>> map = new TreeMap<>();
        for (int i = 0; i < groupSizes.length; i++) {
            int size = groupSizes[i];
            if (map.containsKey(size)) {
                map.get(size).add(i);
            } else {
                group = new ArrayList<>();
                group.add(i);
                map.put(size, group);
            }
        }

        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            int size = entry.getKey();
            List<Integer> value = entry.getValue();
            if (value.size() == size) {
                ans.add(value);
            } else {
                List<Integer> g = new ArrayList<>();
                for (int i = 0; i < value.size(); i++) {
                    if (i % size == 0) {
                        g = new ArrayList<>();
                        ans.add(g);
                    }
                    g.add(value.get(i));
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.groupThePeople(new int[]{3,3,3,3,3,1,3}));
    }
}
