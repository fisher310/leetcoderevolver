package p703;

import java.util.PriorityQueue;

public class KthLargest {
  PriorityQueue<Integer> heap;
  private int max;

  public KthLargest(int k, int[] nums) {
    heap = new PriorityQueue<>(k);
    max = k;
    for (int i = 0, n = nums.length; i < n; i++) {
      add(nums[i]);
    }
  }

  public int add(int val) {
    if (heap.size() < max) {
      heap.offer(val);
    } else {
      if (!heap.isEmpty() && heap.peek() < val) {
        heap.poll();
        heap.offer(val);
      }
    }
    return heap.isEmpty() ? 0 : heap.peek();
  }
}
