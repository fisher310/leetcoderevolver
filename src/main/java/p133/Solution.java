package p133;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {

    public Node cloneGraph(Node node) {
        if (node == null) return null;

        Map<Integer, Node> map = new HashMap<>();

        return createNode(node, map);
    }


    private Node createNode (Node node, Map<Integer, Node> map) {
        Node copy = new Node(node.val);
        map.put(node.val, copy);
        List<Node> copyChild = new ArrayList<>();
        for (Node n : node.neighbors) {
            if (map.containsKey(n.val)) {
                copyChild.add(map.get(n.val));
            } else {
                copyChild.add(createNode(n, map));
            }
        }
        copy.neighbors = copyChild;
        return copy;
    }




}


class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}