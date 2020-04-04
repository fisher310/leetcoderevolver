package p671;

import org.junit.Test;
import util.TreeNode;

import static org.junit.Assert.assertEquals;

public class SolutionTest {

  @Test
  public void findSecondMinimumValue() {
    Solution s = new Solution();
    assertEquals(
        5,
        s.findSecondMinimumValue(
            TreeNode.createTreeNode(new Integer[] {2, 2, 5, null, null, 5, 5})));
    assertEquals(-1, s.findSecondMinimumValue(TreeNode.createTreeNode(new Integer[] {2, 2, 2})));
    assertEquals(
        5,
        s.findSecondMinimumValue(
            TreeNode.createTreeNode(new Integer[] {2, 2, 5, null, null, 5, 7})));
  }
}
