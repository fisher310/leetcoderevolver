package ali;

import java.util.LinkedList;
import java.util.Queue;

public class Solution1 {

    public int lastPersion(int n) {
        if (n < 1) throw new IllegalArgumentException("invalid n");
        if (n == 1) return 1;
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i < n; i++) {
            queue.offer(i);
        }

        int k = 1;
        while (queue.size() > 1) {
            int p = queue.poll();
            if (k != 3) {
                queue.offer(p);
            }
            k = k == 3 ? 1 : k + 1;
        }

        return queue.poll();
    }

    public static void main(String[] args) {

        Solution1 s = new Solution1();
        System.out.println(s.lastPersion(6));
    }


}
