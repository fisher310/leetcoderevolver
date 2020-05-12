package p437;

import org.junit.Test;
import util.TreeNode;

import static org.junit.Assert.*;

public class SolutionTest {

  @Test
  public void pathSum() {
    Solution s = new Solution();
    assertEquals(1, s.pathSum(TreeNode.createTreeNode(new Integer[]{1}), 1));

  }
}