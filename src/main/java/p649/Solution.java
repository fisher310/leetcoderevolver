package p649;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author lihailong
 * @since 2020/12/11 0011
 */
class Solution {

    public String predictPartyVictory(String senate) {
        int r = 0;
        int d = 0;
        Queue<Character> queue = new LinkedList<>();
        for (int i = 0; i < senate.length(); i++) {
            char c = senate.charAt(i);
            queue.offer(c);
            if (c == 'R') r++;
            else if (c == 'D') d++;
        }

        int kd = 0;
        int kr = 0;
        while (!queue.isEmpty()) {
            char c = queue.poll();
            if (c == 'R') {
                if (kr > 0) {
                    kr--;
                    r--;
                } else {
                    kd++;
                    queue.offer('R');
                }
            } else {
                if (kd > 0) {
                    kd--;
                    d--;
                } else {
                    kr++;
                    queue.offer('D');
                }
            }
            if (r == 0) {
                return "Dire";
            }
            if (d == 0) {
                return "Radiant";
            }
        }

        throw new IllegalStateException("should not execute this");
    }
}
