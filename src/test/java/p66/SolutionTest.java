package p66;

import org.junit.Test;

import java.util.Arrays;

public class SolutionTest {

    @Test
    public void plusOne() {
        Solution s = new Solution();
        int[] ans = s.plusOne(new int[]{9, 9});
        System.out.println(Arrays.toString(ans));
        ans = s.plusOne(new int[]{1, 2, 3});
        System.out.println(Arrays.toString(ans));
        ans = s.plusOne(new int[]{9});
        System.out.println(Arrays.toString(ans));
        ans = s.plusOne(new int[]{1, 9});
        System.out.println(Arrays.toString(ans));
        ans = s.plusOne(new int[]{0});
        System.out.println(Arrays.toString(ans));

    }
}