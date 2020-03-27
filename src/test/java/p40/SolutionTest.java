package p40;

import org.junit.Test;

import java.util.List;

public class SolutionTest {

    @Test
    public void combinationSum2() {
        Solution s = new Solution();
        List<List<Integer>> lists = s.combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8);
        System.out.println(lists);
//        s = new Solution();
        lists = s.combinationSum2(new int[]{2, 5, 2, 1, 2}, 5);
        System.out.println(lists);
    }
}