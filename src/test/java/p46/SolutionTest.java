package p46;

import org.junit.Test;

import java.util.List;

public class SolutionTest {

    @Test
    public void permute() {
        Solution s = new Solution();
        List<List<Integer>> permute = s.permute(new int[]{1, 2, 3});
        System.out.println(permute);
    }
}