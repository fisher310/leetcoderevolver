package p636;

import java.util.LinkedList;
import java.util.List;

class Solution {

    public int[] exclusiveTime(int n, List<String> logs) {

        int[] ans = new int[n];
        LinkedList<Log> stack = new LinkedList<>();

        for (String s : logs) {
            String[] log = s.split(":");
            int id = Integer.parseInt(log[0]);
            int tick = Integer.parseInt(log[2]);
            String status = log[1];

            if ("start".equals(status)) {
                stack.push(new Log(id, tick));
            } else if ("end".equals(status)) {
                Log start = stack.pop();
                int interval = tick - start.tick + 1;
                ans[start.id] += interval;

                if (!stack.isEmpty()) {
                    ans[stack.peek().id] -= interval;
                }
            }
        }

        return ans;
    }

    static class Log {
        int id;
        int tick;

        Log(int _id, int _tick) {
            this.id = _id;
            this.tick = _tick;
        }
    }

}
