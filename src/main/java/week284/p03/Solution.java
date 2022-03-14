package week284.p03;

import java.util.*;

/**
 * @author lihailong
 * @since 2022-03-13 11:01:41
 */
public class Solution {
  public int maximumTop(int[] nums, int k) {

    Map<Integer, TreeSet<Integer>> map = new HashMap<>();
    PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
      @Override
      public int compare(Node o1, Node o2) {
        if (o1.value == o2.value) {
          return o1.index - o2.index;
        }
        return o2.value - o1.value;
      }
    });
    for (int i = 0; i < nums.length; i++ ) {
      pq.add(new Node(i, nums[i]));
      TreeSet<Integer> s = map.getOrDefault(nums[i], new TreeSet<>());
      s.add(i);
      map.put(nums[i], s);
    }

    while (!pq.isEmpty()) {
      Node n = pq.poll();
      if (n.index == k) {
        return n.value;
      } else if (n.index > k) {
        continue;
      } else {
        TreeSet<Integer> s = map.get(n.value);
        if (s.ceiling(n.index) != null ) {
          if ((k - n.index - 1) % 2 == 0) {
            return n.value;
          }
        } else {
          return n.value;
        }
      }
    }

    return -1;
  }

  static class Node {
    int index;
    int value;
    Node(int index, int value) {
      this.index = index;
      this.value = value;
    }
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println(s.maximumTop(new int[] {31, 15, 92, 84, 19, 92, 98}, 7) + ":" + 92);
    System.out.println(s.maximumTop(new int[] {31, 15, 92, 84, 19, 92, 98}, 8) + ":" + 98);
    System.out.println(s.maximumTop(new int[] {31, 15, 92, 84, 19, 92, 98}, 6) + ":" + 98);
    System.out.println(s.maximumTop(new int[] {31, 15, 92, 84, 19, 92, 55}, 4) + ":" + 92);
    // len = 23
    System.out.println(
        s.maximumTop(
            new int[] {
              73, 63, 62, 16, 95, 92, 93, 52, 89, 36, 75, 79, 67, 60, 42, 93, 93, 74, 94, 73, 35,
              86, 96
            },
            23));
    System.out.println(s.maximumTop(new int[] {5, 2, 2, 4, 0, 6}, 4));
    // 1. index == k    ok
    // 2. index > k     not ok
    // next_value pos = Math.min(len, map.getOrDefault(Integer.max))
    // 3. index < k   if exists next_value then (k - i - 1) % 2 == 0 else ok

  }
}
