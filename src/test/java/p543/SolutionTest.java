package p543;

import org.junit.Test;
import util.TreeNode;

import static org.junit.Assert.assertEquals;

public class SolutionTest {

  @Test
  public void diameterOfBinaryTree() {
    Solution s = new Solution();
    assertEquals(3, s.diameterOfBinaryTree(TreeNode.createTreeNode(new Integer[] {1, 2, 3, 4, 5})));
    s = new Solution();
    assertEquals(1, s.diameterOfBinaryTree(TreeNode.createTreeNode(new Integer[] {1, 2})));
  }
}
