package p21;

import org.junit.Test;
import util.ListNode;
import util.ListNodeUtil;

public class SolutionTest {

    @Test
    public void mergeTwoLists() {
        Solution s = new Solution();
        ListNode head =
                s.mergeTwoLists(
                        ListNodeUtil.create(new int[]{1, 2, 4}),
                        ListNodeUtil.create(new int[]{1, 3, 4}));
        ListNodeUtil.print(head);
    }
}
