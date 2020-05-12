package p451;

import java.util.*;

/** 根据字符出现频率排序 */
class Solution {
    public String frequencySort(String s) {

        TreeSet<Node> treeSet =
                new TreeSet<>(
                        (o1, o2) -> {
                            if (o2.count == o1.count) {
                                return Character.compare(o1.c, o2.c);
                            }
                            return Integer.compare(o2.count, o1.count);
                        });

        Map<Character, Node> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            if (!map.containsKey(c)) {
                Node node = new Node(c);
                map.put(c, node);
            } else {
                Node node = map.get(c);
                node.incr();
            }
        }

        treeSet.addAll(map.values());

        StringBuilder sb = new StringBuilder();
        for (Node node : treeSet) {
            for (int i = 0; i < node.count; i++) {
                sb.append(node.c);
            }
        }

        return sb.toString();
    }

    private static class Node {
        private char c;
        private int count;

        Node(char c) {
            this.c = c;
            this.count = 1;
        }

        void incr() {
            this.count++;
        }
    }
}
