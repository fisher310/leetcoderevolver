package p31;

import org.junit.Test;

import java.util.Arrays;

public class SolutionTest {

    @Test
    public void nextPermutation() {
        Solution s = new Solution();
        int[] input = new int[]{1, 2, 3};
        s.nextPermutation(input);
        System.out.println(Arrays.toString(input));
        input = new int[]{3, 2, 1};
        s.nextPermutation(input);
        System.out.println(Arrays.toString(input));
    }
}