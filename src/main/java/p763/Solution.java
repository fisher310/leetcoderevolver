package p763;

import java.util.ArrayList;
import java.util.List;

// ababcbaca  defegde hijhklij
// 012345678  9012345 67890123
// a -> 0,2,6,8
// b -> 1,3,5,
// c -> 4,7
// d -> 9,14
// e -> 10,12,15
// f -> 11
// g -> 13
// h -> 16,19
// i -> 17,22
// j -> 18,23
// k -> 20
// l -> 21
class Solution {

    public List<Integer> partitionLabels(String S) {
        int[] last = new int[26];
        for (int i = 0; i < S.length(); i++) {
            last[S.charAt(i) - 'a'] = i;
        }

        int start = 0, end = 0;
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < S.length(); i++) {
            end = Math.max(end, last[S.charAt(i) - 'a']);
            if (i == end) {
                ans.add(end - start + 1);
                start = end + 1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.partitionLabels("abc"));
        System.out.println(s.partitionLabels("abcad"));
        System.out.println(s.partitionLabels("ababcbacadefegdehijhklij"));
    }
}
