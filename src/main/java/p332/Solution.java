package p332;

import java.util.*;

class Solution {

    public List<String> findItinerary(List<List<String>> tickets) {

        Map<String, PriorityQueue<String>> map = new HashMap<>();

        for (List<String> t : tickets) {
            PriorityQueue<String> queue = map.getOrDefault(t.get(0), new PriorityQueue<>());
            queue.add(t.get(1));
            map.put(t.get(0), queue);
        }

        LinkedList<String> ans = new LinkedList<>();
        dfs("JFK", map, ans);
        return ans;
    }

    private void dfs(String curr, Map<String, PriorityQueue<String>> map, LinkedList<String> res) {

        PriorityQueue<String> queue = map.get(curr);
        while (queue != null && !queue.isEmpty()) {
            dfs(queue.poll(), map, res);
        }
        res.addFirst(curr);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
//        [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]

        List<String> ans3 = s.findItinerary(new ArrayList<>() {{
            add(List.of("EZE", "TIA"));
            add(List.of("EZE", "HBA"));
            add(List.of("AXA", "TIA"));
            add(List.of("JFK", "AXA"));
            add(List.of("ANU", "JFK"));
            add(List.of("ADL", "ANU"));
            add(List.of("TIA", "AUA"));
            add(List.of("ANU", "AUA"));
            add(List.of("ADL", "EZE"));
            add(List.of("ADL", "EZE"));
            add(List.of("EZE", "ADL"));
            add(List.of("AXA", "EZE"));
            add(List.of("AUA", "AXA"));
            add(List.of("JFK", "AXA"));
            add(List.of("AXA", "AUA"));
            add(List.of("AUA", "ADL"));
            add(List.of("ANU", "EZE"));
            add(List.of("TIA", "ADL"));
            add(List.of("EZE", "ANU"));
            add(List.of("AUA", "ANU"));
        }});

        System.out.println(ans3);
        //[["JFK","KUL"],["JFK","NRT"],["NRT","JFK"]]

        List<String> ans2 = s.findItinerary(new ArrayList<>() {{
            add(List.of("JFK", "KUL"));
            add(List.of("JFK", "NRT"));
            add(List.of("NRT", "JFK"));
        }});

        System.out.println(ans2);

        List<String> ans = s.findItinerary(new ArrayList<>() {{
            add(List.of("MUC", "LHR"));
            add(List.of("JFK", "MUC"));
            add(List.of("SFO", "SJC"));
            add(List.of("LHR", "SFO"));
        }});

        System.out.println(ans);

        //[["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
        List<String> ans1 = s.findItinerary(new ArrayList<>() {{
            add(List.of("JFK", "SFO"));
            add(List.of("JFK", "ATL"));
            add(List.of("SFO", "ATL"));
            add(List.of("ATL", "JFK"));
            add(List.of("ATL", "SFO"));
        }});

        System.out.println(ans1);

        //["JFK","ATL","JFK","SFO","ATL","SFO"]

        // [["EZE","TIA"],["EZE","HBA"],["AXA","TIA"],["JFK","AXA"],["ANU","JFK"],["ADL","ANU"],["TIA","AUA"],["ANU","AUA"],["ADL","EZE"],["ADL","EZE"],["EZE","ADL"],["AXA","EZE"],["AUA","AXA"],["JFK","AXA"],["AXA","AUA"],["AUA","ADL"],["ANU","EZE"],["TIA","ADL"],["EZE","ANU"],["AUA","ANU"]]

    }
}
