package p105;

import util.TreeNode;

import java.util.HashMap;

/**
 * 前序遍历 preorder = [3,9,20,15,7] 中序遍历 inorder = [9,3,15,20,7]
 */
class Solution {

    private int[] preorder;
    int preIdx = 0;
    HashMap<Integer, Integer> idxMap = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) return null;

        this.preorder = preorder;

        for (int i = 0; i < inorder.length; i++) {
            idxMap.put(inorder[i], i);
        }

        return helper(0, inorder.length);
    }

    TreeNode helper(int inLeft, int inRight) {
        if (inLeft == inRight) {
            return null;
        }

        int rootVal = preorder[preIdx];
        TreeNode root = new TreeNode(rootVal);
        int index = idxMap.get(rootVal);
        preIdx++;
        root.left = helper(inLeft, index);
        root.right = helper(index + 1, inRight);
        return root;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode root = s.buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});

    }
}
