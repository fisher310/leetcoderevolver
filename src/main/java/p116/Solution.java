package p116;


import util.Node;

class Solution {
    public Node connect(Node root) {
        dfs(root);
        return root;
    }

    void dfs(Node node) {
        if (node == null) return;

        if (node.left != null) {
            node.left.next = node.right;
        }
        if (node.right != null && node.next != null) {
            node.right.next = node.next.left;
        }
        dfs(node.left);
        dfs(node.right);
    }

    public static void main(String[] args) {

        Node root = Node.create(new Integer[]{1, 2, 3, 4, 5, 6, 7});
        Solution s = new Solution();
        s.connect(root);
    }
}

