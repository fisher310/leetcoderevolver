package offer33;

import java.util.LinkedList;

/**
 * @author lihailong
 * @since 2021/1/4 0004
 */
class Solution {

    public boolean verifyPostorder(int[] postorder) {

        LinkedList<Integer> stack = new LinkedList<>();
        int root = Integer.MAX_VALUE;
        for (int i = postorder.length - 1; i >= 0; i--) {
            if (postorder[i] > root) return false;
            while (!stack.isEmpty() && stack.peek() > postorder[i]) {
                root = stack.pop();
            }

            stack.add(postorder[i]);
        }
        return true;
        //        return helper(postorder, 0, postorder.length - 1);
    }

    public boolean helper(int[] postorder, int i, int j) {
        if (i >= j) return true;
        int p = i;
        while (postorder[p] < postorder[j]) p++;
        int m = p;
        while (postorder[p] > postorder[j]) p++;

        return p == j && helper(postorder, i, m - 1) && helper(postorder, m, j - 1);
    }
}
