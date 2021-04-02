package p1006;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author lihailong
 * @since 2021-04-01 21:38:57
 */
class Solution {

    public int clumsy(int N) {

        char[] op = new char[]{'*', '/', '+', '-'};
        int tmp = N;
        int i = 0;
        Queue<Integer> queue = new LinkedList<>();
        while (N > 1) {
            switch (op[i++ % 4]) {
                case '*':
                    tmp *= (N - 1);
                    break;
                case '/':
                    tmp /= (N - 1);
                    break;
                case '+':
                case '-':
                    queue.offer(tmp);
                    tmp = N - 1;
                    break;
            }

            N--;
        }

        if (tmp > 0) {
            queue.offer(tmp);
        }

        char[] oop = new char[] {'+', '-'};
        int ans = queue.poll();
        i = 0;
        while (!queue.isEmpty()) {
            switch (oop[i++ % 2]) {
                case '+':
                    ans += queue.poll();
                    break;
                case '-':
                    ans -= queue.poll();
            }
        }

        return ans;
    }
}
