package p1030;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * @author lihailong
 * @since 2021-03-31 22:22:54
 */
public class SolutionTest {

    @Test
    public void allCellsDistOrder() {
        Solution s = new Solution();

        int[][] res = s.allCellsDistOrder(2, 3, 1, 2);
        for (int[] a : res) {
            System.out.println(Arrays.toString(a));
        }
    }
}