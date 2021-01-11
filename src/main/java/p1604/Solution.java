package p1604;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<String> alertNames(String[] keyName, String[] keyTime) {
        int n = keyName.length;

        Map<String, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(keyName[i], s -> new ArrayList<>());
            map.get(keyName[i]).add(convert(keyTime[i]));
        }

        List<String> ans = new ArrayList<>();
        for (Map.Entry<String, List<Integer>> e : map.entrySet()) {
            List<Integer> times = e.getValue();
            if (times.size() < 3) continue;
            times.sort(Integer::compareTo);
            if (needAlert(times)) {
                ans.add(e.getKey());
            }
        }

        ans.sort(String::compareTo);
        return ans;
    }

    private boolean needAlert(List<Integer> times) {
        for (int i = 0; i < times.size() - 2; i++) {
            if (times.get(i + 2) - times.get(i) <= 60) {
                return true;
            }
        }
        return false;
    }

    private int convert(String time) {
        return ((time.charAt(0) - '0') * 10 + time.charAt(1) - '0') * 60
                + ((time.charAt(3) - '0') * 10)
                + (time.charAt(4) - '0');
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(
                s.alertNames(
                        new String[] {"daniel", "daniel", "daniel", "luis", "luis", "luis", "luis"},
                        new String[] {
                            "10:00", "10:40", "11:00", "09:00", "11:00", "13:00", "15:00"
                        }));
        System.out.println(
                s.alertNames(
                        new String[] {"alice", "alice", "alice", "bob", "bob", "bob", "bob"},
                        new String[] {
                            "12:01", "12:00", "18:00", "21:00", "21:20", "21:30", "23:00"
                        }));
        System.out.println(
                s.alertNames(
                        new String[] {"john", "john", "john"},
                        new String[] {"23:58", "23:59", "00:01"}));
        System.out.println(
                s.alertNames(
                        new String[] {
                            "leslie", "leslie", "leslie", "clare", "clare", "clare", "clare"
                        },
                        new String[] {
                            "13:00", "13:20", "14:00", "18:00", "18:51", "19:30", "19:49"
                        }));
    }
}
