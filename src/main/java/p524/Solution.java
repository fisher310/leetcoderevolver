package p524;


import org.junit.Assert;

import java.util.Arrays;
import java.util.List;

class Solution {

    public String findLongestWord(String s, List<String> d) {
        d.sort((o1, o2) -> {
            if (o1.length() == o2.length()) {
                return o1.compareTo(o2);
            }
            return Integer.compare(o2.length(), o1.length());
        });

        int l1 = 0, l2 = 0;

        for (String dic : d) {
            l1 = 0;
            l2 = 0;
            while (l1 < s.length() && l2 < dic.length()) {
                if (s.charAt(l1) == dic.charAt(l2)) {
                    l2++;
                }
                l1++;
            }
            if (l2 == dic.length()) {
                return dic;
            }

        }

        return "";
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        Assert.assertEquals("apple", s.findLongestWord("abpcplea", Arrays.asList("ale", "apple", "monkey", "plea")));
        Assert.assertEquals("a", s.findLongestWord("abpcplea", Arrays.asList("a", "b", "c")));
    }
}
