package p145;

import util.TreeNode;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {

        List<Integer> ans = new ArrayList<>();
        postorder(root, ans);
        return ans;
    }

    private void postorder(TreeNode node, List<Integer> list) {
        if (node == null) return;

        postorder(node.left, list);
        postorder(node.right, list);

        list.add(node.val);

    }
}
