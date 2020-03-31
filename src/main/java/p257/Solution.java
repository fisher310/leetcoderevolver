package p257;

import util.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * common binary tree paths.
 */
class Solution {
    List<String> ans;

    public List<String> binaryTreePaths(TreeNode root) {
        ans = new LinkedList<>();
        dfs(new LinkedList<>(), root);
        return ans;
    }

    void dfs(LinkedList<String> list, TreeNode node) {
        if (node == null) return;
        list.add(String.valueOf(node.val));
        if (node.left == null && node.right == null) {
            ans.add(String.join("->", list));
            list.removeLast();
            return;
        }
        dfs(list, node.left);
        dfs(list, node.right);
        list.removeLast();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        List<String> ans =
                s.binaryTreePaths(TreeNode.createTreeNode(new Integer[]{37, -34, -48, null, -100, -100, 48, null, null, null, null, -54, null, -71, -22, null, null, null, 8}));
        System.out.println(ans);
    }
}
