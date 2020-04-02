package p563;

import org.junit.Test;
import util.TreeNode;

import static org.junit.Assert.assertEquals;

public class SolutionTest {

  @Test
  public void findTilt() {
    assertEquals(1, new Solution().findTilt(TreeNode.createTreeNode(new Integer[]{1,2,3})));
  }
}