package p47;

import org.junit.Test;

import java.util.List;

public class SolutionTest {

    @Test
    public void permuteUnique() {
        Solution s = new Solution();
        List<List<Integer>> lists = s.permuteUnique(new int[]{1, 1});
        System.out.println(lists);
        lists = s.permuteUnique(new int[]{1, 1, 2});
        System.out.println(lists);
        lists = s.permuteUnique(new int[]{3, 3, 0, 3});
        System.out.println(lists);
    }
}