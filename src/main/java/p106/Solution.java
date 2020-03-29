package p106;

import util.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {

    int preInx = 0;
    Map<Integer, Integer> idxMap = new HashMap<>();
    int[] posorder;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        preInx = postorder.length - 1;
        this.posorder = postorder;

        for (int i = 0; i < inorder.length; i++) {
            idxMap.put(inorder[i], i);
        }

        return helper(0, inorder.length);
    }

    TreeNode helper(int inLeft, int inRight) {
        if (inLeft == inRight) {
            return null;
        }

        int rootVal = posorder[preInx--];
        int index = idxMap.get(rootVal);
        TreeNode root = new TreeNode(rootVal);
        root.right = helper(index + 1, inRight);
        root.left = helper(inLeft, index);
        return root;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode root = s.buildTree(new int[]{9, 3, 15, 20, 7}, new int[]{9, 15, 7, 20, 3});
        List<Integer> inorder = new ArrayList<>();
        TreeNode.inOrder(root, inorder);
        System.out.println(inorder);
    }
}
