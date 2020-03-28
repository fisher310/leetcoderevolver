package p93;

import org.junit.Test;

import java.util.List;

public class SolutionTest {

    @Test
    public void restoreIpAddress() {
        Solution s = new Solution();
        List<String> ans = s.restoreIpAddresses("25525511135");
        System.out.println(ans);
    }
}