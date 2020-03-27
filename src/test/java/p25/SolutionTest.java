package p25;

import org.junit.Test;
import util.ListNode;
import util.ListNodeUtil;

public class SolutionTest {

    @Test
    public void reverseKGroup() {
        Solution s = new Solution();
        ListNode node = s.reverseKGroup(ListNodeUtil.create(new int[]{1, 2, 3, 4, 5}), 3);
        ListNodeUtil.print(node);

    }
}