package p104;
import util.TreeNode;
/**
 * 给定一个二叉树，找出其最大深度。

二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。

说明: 叶子节点是指没有子节点的节点。

示例：
给定二叉树 [3,9,20,null,null,15,7]，

    3
   / \
  9  20
    /  \
   15   7
返回它的最大深度 3 。
 */
public class Solution {
    int ans = 0;

    public int maxDepth(TreeNode root) {
        dfs(root, 0);
        return ans;
    }

    void dfs(TreeNode node, int level) {
        if (node == null) {
            if (level > ans) {
                ans = level;
            }
            return;
        }
        dfs(node.left, level + 1);
        dfs(node.right, level + 1);
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.createTreeNode(new Integer[] { 3, 9, 20, null, null, 15, 7 });
        Solution s = new Solution();
        System.out.println(s.maxDepth(root));
    }
}