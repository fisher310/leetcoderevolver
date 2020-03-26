package p23;

import org.junit.Test;
import util.ListNode;
import util.ListNodeUtil;

public class SolutionTest {

    @Test
    public void mergeKLists() {
        Solution s = new Solution();
        ListNode[] lists =
                new ListNode[]{
                        ListNodeUtil.create(new int[]{1, 4, 5}),
                        ListNodeUtil.create(new int[]{1, 3, 4}),
                        ListNodeUtil.create(new int[]{2, 6})
                };
        ListNode head = s.mergeKLists(lists);
        ListNodeUtil.print(head);
    }
}
