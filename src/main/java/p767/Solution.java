package p767;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Solution {
    public String reorganizeString(String S) {

        PriorityQueue<Node> heap = new PriorityQueue<>((o1, o2) -> Integer.compare(o2.count, o1.count));
        Map<Character, Integer> map = new HashMap<>();
        for (char c : S.toCharArray()) {
            int count = map.getOrDefault(c, 0) + 1;
            if (count > S.length() / 2 + 1) {
                return "";
            }
            map.put(c, count);
        }

        for (Map.Entry<Character, Integer> e : map.entrySet()) {
            heap.offer(new Node(e.getKey(), e.getValue()));
        }

        StringBuilder ans = new StringBuilder();
        while (heap.size() >= 2) {
            Node n1 = heap.poll();
            Node n2 = heap.poll();

            ans.append(n1.c).append(n2.c);
            n1.count--;
            n2.count--;
            if (n1.count > 0) heap.offer(n1);
            if (n2.count > 0) heap.offer(n2);
        }
        if (heap.size() > 0) {
            Node n = heap.poll();
            if (n.count > 1) return "";
            ans.append(n.c);
        }

        return ans.toString();
    }

    private static class Node {
        char c;
        int count;
        Node(char c, int count) {
            this.c = c;
            this.count = count;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.reorganizeString("aab"));
        System.out.println(s.reorganizeString("aaab"));
    }
}
