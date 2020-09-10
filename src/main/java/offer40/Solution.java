package offer40;

import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {

        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o2, o1));
        for (int n : arr) {
            if (pq.size() < k) {
                pq.offer(n);
            } else if (pq.peek() > n) {
                pq.poll();
                pq.offer(n);
            }
        }

        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = pq.poll();
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] ans = s.getLeastNumbers(new int[]{3,2,1}, 2);
        System.out.println(Arrays.toString(ans));
    }
}
