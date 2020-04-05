package p1372;

import org.junit.Test;
import util.TreeNode;

import static org.junit.Assert.assertEquals;

public class SolutionTest {

  @Test
  public void longestZigZag() {
    Solution s = new Solution();
    assertEquals(0, s.longestZigZag(TreeNode.createTreeNode(new Integer[] {1})));
    assertEquals(
        3,
        s.longestZigZag(
            TreeNode.createTreeNode(
                new Integer[] {
                  1, null, 1, 1, 1, null, null, 1, 1, null, 1, null, null, null, 1, null, 1
                })));

    assertEquals(
        4,
        s.longestZigZag(
            TreeNode.createTreeNode(new Integer[] {1, 1, 1, null, 1, null, null, 1, 1, null, 1})));

  }
}
