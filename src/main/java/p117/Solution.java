package p117;

import util.Node;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public Node connect(Node root) {
        if (root == null) return null;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (node.left != null) {
                if (node.right != null) {
                    node.left.next = node.right;
                } else {
                    Node ne = node.next;
                    while (ne != null) {
                        if (ne.left != null) {
                            node.left.next = ne.left;
                            break;
                        } else if (ne.right != null) {
                            node.left.next = ne.right;
                            break;
                        }
                        ne = ne.next;
                    }
                }
                queue.offer(node.left);
            }

            if (node.right != null) {
                Node ne = node.next;
                while (ne != null) {
                    if (ne.left != null) {
                        node.right.next = ne.left;
                        break;
                    } else if (ne.right != null) {
                        node.right.next = ne.right;
                        break;
                    }
                    ne = ne.next;
                }
                queue.offer(node.right);
            }
        }

        return root;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        Node root = Node.create(new Integer[]{1, 2, 3, 4, 5, null, 7});
        s.connect(root);

        root = Node.create(new Integer[]{1, 2, 3, 4, 5, null, 6, 7, null, null, null, null, 8});
        s.connect(root);

        root = Node.create(new Integer[]{2, 1, 3, 0, 7, 9, 1, 2, null, 1, 0, null, null, 8, 8, null, null, null, null, 7});
        s.connect(root);
    }
}
