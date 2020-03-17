package util;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        this.val = x;
    }

    public static TreeNode creatTreeNode(Integer[] input) {
        if (input == null || input.length == 0) {
            return null;
        }
        TreeNode[] nodes = new TreeNode[input.length];
        for (int i = 0, n = input.length; i < n; i++) {
            if (input[i] != null) {
                nodes[i] = new TreeNode(input[i]);
            } else {
                nodes[i] = null;
            }
        }

        for (int i = 0, n = input.length; i < n; i++) {
            if (i * 2 + 1 < n && nodes[i] != null) {
                nodes[i].left = nodes[i * 2 + 1];
            }

            if (nodes[i] != null && i * 2 + 2 < n) {
                nodes[i].right = nodes[i * 2 + 2];
            }
        }
        return nodes[0];
    }
}
