package p842;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 将数组拆分成斐波那契序列
 */
class Solution {
    List<Integer> res;

    public List<Integer> splitIntoFibonacci(String S) {
        if (S == null || S.length() == 0) return Collections.emptyList();

        // 先选第一个数字
        res = new ArrayList<>();
        dfs(S, 0);

        return res;
    }

    boolean dfs(String s, int start) {
        //        System.out.print(res);
        //        System.out.println(": " + start);
        if (start == s.length()) {
            return res.size() > 2;
        }

        int num = 0;
        for (int i = start; i < s.length(); i++) {
            if (s.charAt(start) == '0' && i > start) return false;

            num = num * 10 + s.charAt(i) - '0';
            if (num < 0) return false;

            if (res.size() < 2 || num == res.get(res.size() - 1) + res.get(res.size() - 2)) {
                res.add(num);
                if (dfs(s, i + 1)) return true;
                res.remove(res.size() - 1);
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        List<Integer> ans = s.splitIntoFibonacci("123456579");
        System.out.println(ans);
        ans = s.splitIntoFibonacci("11235813");
        System.out.println(ans);
        ans = s.splitIntoFibonacci("112358130");
        System.out.println(ans);
        System.out.println(s.splitIntoFibonacci("0123"));
        System.out.println(s.splitIntoFibonacci("1101111"));
        System.out.println(s.splitIntoFibonacci("214748364721474836422147483641"));
    }
}
