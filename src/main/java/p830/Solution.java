package p830;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * >=3 []
 *
 * @author lihailong
 * @since 2020/12/16 0016
 */
class Solution {
    public List<List<Integer>> largeGroupPositions(String s) {
        if (s == null || s.length() < 3) return Collections.emptyList();
        List<List<Integer>> ans = new ArrayList<>();
        int i = 0, N = s.length();

        for (int j = 0; j < N; j++) {
            if (j == N - 1 || s.charAt(j) != s.charAt(j + 1)) {
                if (j - i + 1 >= 3) {
                    ans.add(Arrays.asList(i, j));
                }
                i = j + 1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.largeGroupPositions("aaa"));
        System.out.println(s.largeGroupPositions("abbxxxxzyy"));
        System.out.println(s.largeGroupPositions("abcdddeeeeaabbbcd"));
    }
}
