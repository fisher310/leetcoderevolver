package p94;

import util.TreeNode;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        inOrder(ans, root);
        return ans;
    }

    private void inOrder(List<Integer> list, TreeNode node) {
        if (node == null) {
            return;
        }
        if (node.left != null) {
            inOrder(list, node.left);
        }
        list.add(node.val);
        if (node.right != null) {
            inOrder(list, node.right);
        }
    }
}
