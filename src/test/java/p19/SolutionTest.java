package p19;

import org.junit.Test;
import util.ListNode;
import util.ListNodeUtil;

public class SolutionTest {

    @Test
    public void removeNthFromEnd() {
        Solution solution = new Solution();
        ListNode head =
                ListNodeUtil.create(
                        new int[]{
                                1,
                        });
        ListNode head2 = solution.removeNthFromEnd(head, 1);
        ListNodeUtil.print(head2);
        ListNodeUtil.print(solution.removeNthFromEnd(ListNodeUtil.create(new int[]{1, 2}), 2));
        ListNodeUtil.print(
                solution.removeNthFromEnd(ListNodeUtil.create(new int[]{1, 2, 3, 4, 5}), 2));
    }
}
