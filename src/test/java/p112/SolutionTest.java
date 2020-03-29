package p112;

import org.junit.Test;
import util.TreeNode;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SolutionTest {

    @Test
    public void hasPathSum() {
        Solution s = new Solution();
        assertFalse(s.hasPathSum(TreeNode.createTreeNode(new Integer[]{1, 2}), 1));
        assertFalse(s.hasPathSum(TreeNode.createTreeNode(new Integer[]{1}), 0));
        assertFalse(s.hasPathSum(TreeNode.createTreeNode(new Integer[]{}), 0));
        assertTrue(
                s.hasPathSum(
                        TreeNode.createTreeNode(
                                new Integer[]{
                                        5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, 1
                                }),
                        22));
    }
}
