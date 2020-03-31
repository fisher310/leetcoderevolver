package p230;

import util.TreeNode;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>(k);
        dfs(root, list, k);
        return list.get(k - 1);
    }

    void dfs(TreeNode node, List<Integer> list, int k) {
        if (node == null || list.size() == k) {
            return;
        }
        dfs(node.left, list, k);
        list.add(node.val);
        dfs(node.right, list, k);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int ans = s.kthSmallest(TreeNode.createTreeNode(new Integer[]{3, 1, 4, null, 2}), 1);
        System.out.println(ans);
    }
}
