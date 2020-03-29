package p199;

import util.TreeNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    List<Integer> ans = new ArrayList<>();
    Set<Integer> visited = new HashSet<>();

    public List<Integer> rightSideView(TreeNode root) {
        dfs(root, 0);
        return ans;
    }

    void dfs(TreeNode node, int level) {
        if (null == node) return;

        if (!visited.contains(level)) {
            ans.add(node.val);
            visited.add(level);
        }
        dfs(node.right, level + 1);
        dfs(node.left, level + 1);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        List<Integer> ans =
                s.rightSideView(TreeNode.createTreeNode(new Integer[]{1, 2, 3, null, 5, null, 4, 6, 7}));
        System.out.println(ans);
    }
}
