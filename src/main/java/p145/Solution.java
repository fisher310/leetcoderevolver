package p145;

import util.TreeNode;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) return Collections.emptyList();
        LinkedList<TreeNode> stack = new LinkedList<>();
        LinkedList<Integer> ans = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pollLast();
            ans.addFirst(node.val);
            if (node.left != null) {
                stack.add(node.left);
            }
            if (node.right != null) {
                stack.add(node.right);
            }
        }
        return ans;
    }
}
