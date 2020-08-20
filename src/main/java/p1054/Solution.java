package p1054;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Solution {

    public int[] rearrangeBarcodes(int[] barcodes) {
        Map<Integer, Bar> map = new HashMap<>();
        for (int i = 0; i < barcodes.length; i++) {
            Bar b = map.getOrDefault(barcodes[i], new Bar(barcodes[i]));
            b.count++;
            map.put(barcodes[i], b);
        }

        PriorityQueue<Bar> heap = new PriorityQueue<>((o1, o2) -> Integer.compare(o2.count, o1.count));
        for (Bar b : map.values()) {
            heap.offer(b);
        }

        int[] ans = new int[barcodes.length];

        int i = 0;
        while (heap.size() >= 2) {
            Bar b1 = heap.poll();
            Bar b2 = heap.poll();
            ans[i++] = b1.val;
            ans[i++] = b2.val;
            b1.count--;
            b2.count--;
            if (b1.count > 0) {
                heap.offer(b1);
            }
            if (b2.count > 0) {
                heap.offer(b2);
            }
        }
        if (!heap.isEmpty()) {
            ans[i++] = (heap.poll().val);
        }
        return ans;
    }

    private static class Bar {
        int val;
        int count;

        Bar(int val) {
            this.val = val;
            this.count = 0;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.rearrangeBarcodes(new int[]{1, 1, 1, 2, 2, 2})));
        System.out.println(Arrays.toString(s.rearrangeBarcodes(new int[]{1, 1, 1, 1, 2, 2, 3, 3})));
    }
}
