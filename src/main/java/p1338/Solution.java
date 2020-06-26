package p1338;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int minSetSize(int[] arr) {
        if (null == arr) return 0;

        int len = arr.length;

        Map<Integer, Node> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            Node n = map.getOrDefault(arr[i], new Node(arr[i]));
            n.count += 1;
            map.put(arr[i], n);
        }

        ArrayList<Node> list = new ArrayList<>(map.values());
        list.sort(
                new Comparator<Node>() {
                    @Override
                    public int compare(Node n1, Node n2) {
                        return Integer.compare(n2.count, n1.count);
                    }
                });

        int len2 = 0;
        for (int i = 0; i < list.size(); i++) {
            len2 += list.get(i).count;
            if (len2 * 2 >= len) {
                return i + 1;
            }
        }
        throw new IllegalStateException("");
    }

    static class Node {
        int value;
        int count;

        Node(int value) {
            this.value = value;
            this.count = 0;
        }
    }
}
