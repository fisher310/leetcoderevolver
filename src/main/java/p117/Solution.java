package p117;

import util.Node;

class Solution {
    public Node connect(Node root) {
        Node curr = root;
        while (curr != null) {
            Node start = new Node(0);
            Node pre = start;
            while (curr != null) {
                if (curr.left != null) {
                    pre.next = curr.left;
                    pre = pre.next;
                }
                if (curr.right != null) {
                    pre.next = curr.right;
                    pre = pre.next;
                }
                curr = curr.next;
            }
            curr = start.next;
        }
        return root;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        Node root = Node.create(new Integer[]{1, 2, 3, 4, 5, null, 7});
        s.connect(root);

        root = Node.create(new Integer[]{1, 2, 3, 4, 5, null, 6, 7, null, null, null, null, 8});
        s.connect(root);

        root =
                Node.create(
                        new Integer[]{
                                2, 1, 3, 0, 7, 9, 1, 2, null, 1, 0, null, null, 8, 8, null, null, null,
                                null, 7
                        });
        s.connect(root);
    }
}
