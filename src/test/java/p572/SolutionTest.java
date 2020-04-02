package p572;

import org.junit.Test;
import util.TreeNode;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SolutionTest {

  @Test
  public void isSubtree() {
    assertTrue(
        new Solution()
            .isSubtree(
                TreeNode.createTreeNode(new Integer[] {3, 4, 5, 1, 2}),
                TreeNode.createTreeNode(new Integer[] {4, 1, 2})));
    assertFalse(
        new Solution()
            .isSubtree(
                TreeNode.createTreeNode(new Integer[] {3, 4, 5, 1, 2, null, null, null, null, 0}),
                TreeNode.createTreeNode(new Integer[] {4, 1, 2})));
  }
}
