package p98;

import util.TreeNode;

public class Solution {
    public boolean isValidBST(TreeNode root) {
        return doValid(root, null, null);
    }

    private boolean doValid(TreeNode node, Integer lower, Integer upper) {
        if (node == null) {
            return true;
        }

        if (lower != null && node.val <= lower) {
            return false;
        }
        if (upper != null && node.val >= upper) {
            return false;
        }

        if (!doValid(node.right, node.val, upper)) {
            return false;
        }
        if (!doValid(node.left, lower, node.val)) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        // TreeNode root = TreeNode.creatTreeNode(new Integer[]{5,1,4,null, null, 3,
        // 6});
        TreeNode root = TreeNode.creatTreeNode(new Integer[] { 10, 5, 15, null, null, 6, 20 });
        Solution s = new Solution();
        System.out.println(s.isValidBST(root));
    }
}