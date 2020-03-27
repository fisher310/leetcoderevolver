package p34;

import org.junit.Test;

import java.util.Arrays;

public class SolutionTest {

    @Test
    public void searchRange() {
        Solution s = new Solution();
        int[] ans = s.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8);
        System.out.println(Arrays.toString(ans));
        ans = s.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 6);
        System.out.println(Arrays.toString(ans));
        ans = s.searchRange(new int[]{2, 2,}, 1);
        System.out.println(Arrays.toString(ans));
    }
}
