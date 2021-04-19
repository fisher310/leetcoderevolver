package p228;

import org.apache.commons.math3.linear.ConjugateGradient;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author lihailong
 * @since 2021/04/19 11:26:01
 */
class Solution {

    public List<String> summaryRanges(int[] nums) {

        int n = nums.length;
        if (n == 0) return Collections.emptyList();

        List<String> res = new ArrayList<>();
        int s = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1] + 1) {
                continue;
            }

            if (nums[i - 1] == s) {
                res.add(String.valueOf(s));
            } else {
                res.add(s + "->" + nums[i - 1]);
            }
            s = nums[i];
        }

        if (s == nums[n - 1]) {
            res.add(String.valueOf(s));
        } else {
            res.add(s + "->" + nums[n - 1]);
        }

        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.summaryRanges(new int[]{0, 1, 2, 4, 5, 7}));
        System.out.println(s.summaryRanges(new int[]{0, 2, 3, 4, 6, 8, 9}));
        System.out.println(s.summaryRanges(new int[]{-1}));
    }
}
