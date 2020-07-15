package p187;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {

    public List<String> findRepeatedDnaSequences(String s) {

        Set<String> set = new HashSet<>();

        Set<String> res = new HashSet<>();
        for (int i = 0, n = s.length() - 10; i <= n; i++) {
            String ss = s.substring(i, i + 10);
            if (set.contains(ss)) {
                res.add(ss);
            }
            set.add(ss);
        }

        return new ArrayList<>(res);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.findRepeatedDnaSequences("AAAAAAAAAAA"));
        System.out.println(s.findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"));
    }
}
