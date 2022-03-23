package p993;

import util.TreeNode;

public class Solution {

    private int dx;
    private int dy;
    private TreeNode px;
    private TreeNode py;

    public boolean isCousins(TreeNode root, int x, int y) {
        travel(root, null, x, y, 0);

        return dx == dy && px != py;
    }

    void travel(TreeNode node, TreeNode parent,  int x, int y, int deep) {
        if (node == null) {
            return;
        }
        if (node.val == x) {
            dx = deep;
            px = parent;
        }
        if (node.val == y) {
            dy = deep;
            py = parent;
        }
        travel(node.left, node, x, y, deep + 1);
        travel(node.right, node, x, y, deep + 1);
    }
}