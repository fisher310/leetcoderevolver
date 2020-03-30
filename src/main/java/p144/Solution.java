package p144;

import util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树的前序遍历
 * 尝试使用迭代方式
 */
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                ans.add(curr.val);
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            curr = curr.right;
        }

        return ans;
    }

    private void preorder(TreeNode node, List<Integer> list) {
        if (node == null) return;
        list.add(node.val);

        preorder(node.left, list);
        preorder(node.right, list);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        List<Integer> ans = s.preorderTraversal(TreeNode.createTreeNode(new Integer[]{1, 5, 2, 3, 4}));
        System.out.println(ans);
    }
}
