package p347;

import java.util.*;

/** 前 K 个高频元素 */
class Solution {

  public List<Integer> topKFrequent(int[] nums, int k) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int n : nums) {
      map.put(n, map.getOrDefault(n, 0) + 1);
    }

    PriorityQueue<Node> queue =
        new PriorityQueue<>(k, (o1, o2) -> Integer.compare(o1.frequent, o2.frequent));

    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
      if (queue.size() == k) {
        if (queue.peek().frequent < entry.getValue()) {
          queue.poll();
          queue.offer(new Node(entry.getKey(), entry.getValue()));
        }

      } else {
        queue.offer(new Node(entry.getKey(), entry.getValue()));
      }
    }

    List<Integer> ans = new LinkedList<>();
    while (!queue.isEmpty()) {
      ans.add(queue.poll().val);
    }
    return ans;
  }

  private static class Node {
    int val;
    int frequent;

    Node(int _val, int _frequent) {
      this.val = _val;
      this.frequent = _frequent;
    }
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    List<Integer> ans = s.topKFrequent(new int[] {1, 1, 1, 2, 2, 3}, 2);
    for (int n : ans) {
      System.out.print(n + " ");
    }
    System.out.println();
  }
}
