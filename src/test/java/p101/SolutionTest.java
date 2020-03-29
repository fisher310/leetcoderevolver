package p101;

import org.junit.Test;
import util.TreeNode;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SolutionTest {

    @Test
    public void isSymmetric() {
        Solution s = new Solution();
        assertTrue(s.isSymmetric(TreeNode.createTreeNode(new Integer[]{1, 2, 2, 3, 4, 4, 3})));
        assertFalse(s.isSymmetric(TreeNode.createTreeNode(new Integer[]{1, 2, 2, null, 3, null, 3})));
    }
}
