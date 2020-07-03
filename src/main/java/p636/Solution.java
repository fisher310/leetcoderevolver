package p636;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class Solution {

    public int[] exclusiveTime(int n, List<String> logs) {

        int[] ans = new int[n];
        LinkedList<Log> stack = new LinkedList<>();

        int preTick = 0;
        String preStatus = "";
        for (String s : logs) {
            String[] log = s.split(":");
            int id = Integer.parseInt(log[0]);
            int tick = Integer.parseInt(log[2]);
            String status = log[1];

            if ("start".equals(status)) {
                if (!stack.isEmpty()) {
                    if (preStatus.equals("end")) {
                        stack.peek().addDuration(tick - preTick - 1);
                    } else {
                        stack.peek().addDuration(tick - preTick);
                    }
                }
                stack.push(new Log(id, tick));
            } else if ("end".equals(status)) {
                Log start = stack.pop();
                if (start.duration == 0) {
                    ans[id] += tick + 1 - start.tick;
                } else {
                    ans[id] += tick - preTick + start.duration;
                }
            }
                preTick = tick;
            preStatus = status;
        }

        return ans;
    }

    static class Log {
        int id;
        int duration;
        int tick;

        Log(int _id, int _tick) {
            this.id = _id;
            this.tick = _tick;
            this.duration = 0;
        }

        void addDuration(int delta) {
            this.duration += delta;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        List<String> log;
        log = Arrays.asList("0:start:0", "0:start:1", "0:start:2", "0:end:3", "0:end:4", "0:end:5");
        System.out.println(Arrays.toString(s.exclusiveTime(1, log)));

        log = Arrays.asList("0:start:0", "0:start:2", "0:end:5", "0:start:6", "0:end:6", "0:end:7");
        int[] ans = s.exclusiveTime(1, log);
        System.out.println(Arrays.toString(ans));

        log = Arrays.asList("0:start:0", "1:start:2", "1:end:5", "0:end:6");
        System.out.println(Arrays.toString(s.exclusiveTime(2, log)));

        log = Arrays.asList("0:start:0", "0:start:2", "0:end:5", "1:start:7", "1:end:7", "0:end:8");
        System.out.println(Arrays.toString(s.exclusiveTime(2, log)));
    }
}
