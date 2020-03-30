package p144;

import util.TreeNode;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        preorder(root, ans);
        return ans;
    }

    private void preorder(TreeNode node, List<Integer> list) {
        if (node == null) return;
        list.add(node.val);

        preorder(node.left, list);
        preorder(node.right, list);
    }
}
