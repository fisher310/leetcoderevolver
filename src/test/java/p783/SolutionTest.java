package p783;

import org.junit.Test;
import util.TreeNode;

import static org.junit.Assert.assertEquals;

public class SolutionTest {

  @Test
  public void minDiffInBST() {
    Solution s = new Solution();
    assertEquals(1, s.minDiffInBST(TreeNode.createTreeNode(new Integer[] {4, 2, 6, 1, 3})));
    assertEquals(
        6,
        s.minDiffInBST(
            TreeNode.createTreeNode(
                new Integer[] {27, null, 34, null, 58, 50, null, 44, null, null, null})));
  }
}
