package p606;

import org.junit.Test;
import util.TreeNode;

import static org.junit.Assert.assertEquals;

public class SolutionTest {

  @Test
  public void tree2str() {
    Solution s = new Solution();
    assertEquals("3", "1()(2()(3()(4()(5()(6)))))",
            s.tree2str(TreeNode.createTreeNode(new Integer[]{1,null,2,null,3,null,4,null,5,null,6})));
    assertEquals(
        "1", "1(2(4))(3)", s.tree2str(TreeNode.createTreeNode(new Integer[] {1, 2, 3, 4})));
    assertEquals(
        "2", "1(2()(4))(3)", s.tree2str(TreeNode.createTreeNode(new Integer[] {1, 2, 3, null, 4})));
  }
}
