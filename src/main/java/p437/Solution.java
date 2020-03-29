package p437;

import util.TreeNode;

import java.util.ArrayList;
import java.util.List;

class Solution {

    int ans = 0;

    public int pathSum(TreeNode root, int sum) {
        dfs(new ArrayList<Node>(), root, sum, root);
        return ans;
    }

    void dfs(List<Node> list, TreeNode node, int target, TreeNode parent) {
        if (node == null) return;

        dfs(list, node.left, target, node);
        dfs(list, node.right, target, node);

        int val = node.val;

        if (val == target) ans++;

        for (Node nd : list) {
            if (nd.parent == node) {
                nd.val += val;
                nd.parent = parent;
                if (nd.val == target) ans++;
            }
        }
        list.add(new Node(val, parent));
    }

    static class Node {
        int val;
        TreeNode parent;

        Node(int val, TreeNode parent) {
            this.val = val;
            this.parent = parent;
        }
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        int ans = s.pathSum(TreeNode.createTreeNode(new Integer[]{10, 5, -3, 3, 2, null, 11, 3, -2, null, 1}), 8);
        System.out.println(ans);
    }
}
