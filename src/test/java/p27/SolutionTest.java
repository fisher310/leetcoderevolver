package p27;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

    @Test
    public void removeElement() {
        Solution s = new Solution();
        int ans = s.removeElement(new int[]{3, 2, 2, 3}, 2);
        Assert.assertEquals(2, ans);
        ans = s.removeElement(new int[]{0, 1, 2, 2, 3, 0, 4, 2}, 2);
        Assert.assertEquals(5, ans);
    }
}
