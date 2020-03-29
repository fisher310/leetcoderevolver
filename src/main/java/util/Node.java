package util;

import java.util.LinkedList;
import java.util.Queue;

public class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node(int _val) {
        this.val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        this.val = _val;
        this.left = _left;
        this.right = _right;
        this.next = _next;
    }

    public static Node create(Integer[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        Node root = new Node(nums[0]);
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        int i = 1;
        while (!queue.isEmpty() && i < nums.length) {
            Node current = queue.poll();
            Integer nl = nums[i++];
            if (nl != null) {
                current.left = new Node(nl);
                queue.offer(current.left);
            }
            if (i < nums.length) {
                Integer nr = nums[i++];
                if (nr != null) {
                    current.right = new Node(nr);
                    queue.offer(current.right);
                }
            }
        }
        return root;
    }
}
