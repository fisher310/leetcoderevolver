package p92;

import org.junit.Test;
import util.ListNode;
import util.ListNodeUtil;

public class SolutionTest {

    @Test
    public void reverseBetween() {
        Solution s = new Solution();
        ListNode node = s.reverseBetween(ListNodeUtil.create(new int[]{1, 2, 3, 4, 5}), 2, 4);
        ListNodeUtil.print(node);
        node = s.reverseBetween(ListNodeUtil.create(new int[]{1, 2, 3, 4, 5}), 1, 5);
        ListNodeUtil.print(node);
        node = s.reverseBetween(ListNodeUtil.create(new int[]{1, 2, 3, 4, 5}), 2, 5);
        ListNodeUtil.print(node);
        node = s.reverseBetween(ListNodeUtil.create(new int[]{1, 2, 3, 4, 5}), 1, 4);
        ListNodeUtil.print(node);
        node = s.reverseBetween(ListNodeUtil.create(new int[]{1}), 1, 1);
        ListNodeUtil.print(node);
    }
}