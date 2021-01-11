package m04dot12;

import org.junit.Test;
import util.TreeNode;

import static org.junit.Assert.assertEquals;

/**
 * @author lihailong
 * @since 2021/1/5 0005
 */
public class SolutionTest {

    @Test
    public void pathSum() {

        Solution s = new Solution();
        assertEquals(
                2,
                s.pathSum(
                        TreeNode.createTreeNode(
                                new Integer[] {1, null, 2, null, 3, null, 4, null, 5}),
                        3));
        assertEquals(
                3,
                s.pathSum(
                        TreeNode.createTreeNode(
                                new Integer[] {5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5, 1}),
                        22));
    }
}
