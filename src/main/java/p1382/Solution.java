package p1382;

import util.TreeNode;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public TreeNode balanceBST(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        inOrder(root, list);
        return reconstruct(list, 0, list.size() - 1);
    }

    void inOrder(TreeNode root, List<TreeNode> list) {
        if (root == null) return;

        inOrder(root.left, list);
        list.add(root);
        inOrder(root.right, list);
    }

    TreeNode reconstruct(List<TreeNode> list, int start, int end) {
        if (start > end) return null;
        if (start == end) {
            TreeNode n = list.get(start);
            n.left = null;
            n.right = null;
            return n;
        }
        int mid = (start + end ) >> 1;
        TreeNode n = list.get(mid);
        n.left = reconstruct(list, start, mid - 1);
        n.right = reconstruct(list, mid + 1, end);
        return n;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode root = s.balanceBST(TreeNode.createTreeNode(new Integer[]{1,null,2,null,3,null,4,null,null}));

    }
}
