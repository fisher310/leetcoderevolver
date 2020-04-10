package p414;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.stream.Collectors;

/** 第三大的数 */
class Solution {
  public int thirdMax(int[] nums) {

    PriorityQueue<Integer> priorityQueue =
        new PriorityQueue<>(
            (o1, o2) -> {
              return o2.compareTo(o1);
            });
    Set<Integer> s = Arrays.stream(nums).boxed().collect(Collectors.toSet());
    priorityQueue.addAll(s);

    Integer top = priorityQueue.peek();
    Integer val = null;
    for (int i = 0; i < 3; i++) {
      val = priorityQueue.poll();
      if (val == null) {
        return top;
      }
    }
    return val;
  }
}
