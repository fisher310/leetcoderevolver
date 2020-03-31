package p173;

import util.TreeNode;

import java.util.LinkedList;

public class BSTIterator {

    private LinkedList<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        stack = new LinkedList<>();
        TreeNode curr = root;
        while (curr != null) {
            stack.push(curr);
            curr = curr.left;
        }
    }

    /**
     * @return the next smallest number
     */
    public int next() {
        TreeNode node = stack.pop();
        TreeNode right = node.right;
        while (right != null) {
            stack.push(right);
            right = right.left;
        }
        return node.val;
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    public static void main(String[] args) {
        BSTIterator iter = new BSTIterator(TreeNode.createTreeNode(new Integer[]{7, 3, 15, null, null, 9, 20}));
        while (iter.hasNext()) {
            System.out.print(iter.next() + " ");
        }
        System.out.println();
    }
}
