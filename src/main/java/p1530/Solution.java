package p1530;

import org.junit.Assert;
import util.TreeNode;

import java.util.*;

class Solution {

    Map<TreeNode, TreeNode> parents;
    int distance;
    int ans;
    Set<TreeNode> visited;

    public int countPairs(TreeNode root, int distance) {
        if (root == null) return 0;

        this.ans = 0;
        this.distance = distance;
        this.visited = new HashSet<>();
        List<TreeNode> leafs = new ArrayList<>();
        parents = new HashMap<>();

        preorder(null, root, leafs);
        for (int i = 0; i < leafs.size(); i++) {
            visited.clear();
            dfs(leafs.get(i), 0);
        }

        return ans / 2;
    }

    private void dfs(TreeNode node, int dis) {
        visited.add(node);
        if (node.left == null && node.right == null && dis != 0) {
            if (dis <= this.distance) {
                ans++;
            }
            return;
        }

        if (dis > distance) {
            return;
        }

        TreeNode parent = parents.get(node);
        if (parent != null && !visited.contains(parent)) {
            dfs(parent, dis + 1);
        }

        if (node.left != null && !visited.contains(node.left)) {
            dfs(node.left, dis + 1);
        }

        if (node.right != null && !visited.contains(node.right)) {
            dfs(node.right, dis + 1);
        }
    }

    private void preorder(TreeNode parent, TreeNode node, List<TreeNode> leafs) {
        if (parent != null) {
            parents.put(node, parent);
        }
        if (node.left == null && node.right == null) {
            leafs.add(node);
            return;
        }

        if (node.left != null) {
            preorder(node, node.left, leafs);
        }
        if (node.right != null) {
            preorder(node, node.right, leafs);
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        Assert.assertEquals(
                1, s.countPairs(TreeNode.createTreeNode(new Integer[] {1, 2, 3, null, 4}), 3));
        Assert.assertEquals(
                2, s.countPairs(TreeNode.createTreeNode(new Integer[] {1, 2, 3, 4, 5, 6, 7}), 3));
        Assert.assertEquals(
                1,
                s.countPairs(
                        TreeNode.createTreeNode(
                                new Integer[] {
                                    7, 1, 4, 6, null, 5, 3, null, null, null, null, null, 2
                                }),
                        3));
        Assert.assertEquals(0, s.countPairs(TreeNode.createTreeNode(new Integer[] {100}), 1));
        Assert.assertEquals(1, s.countPairs(TreeNode.createTreeNode(new Integer[] {1, 1, 1}), 2));
    }
}
