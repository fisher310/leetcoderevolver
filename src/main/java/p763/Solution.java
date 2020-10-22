package p763;

import java.util.*;

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
        int N = S.length();
        Map<Character, int[]> map = new HashMap<>();
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            map.computeIfAbsent(c, e -> new int[] {N, 0});
            map.get(c)[0] = Math.min(i, map.get(c)[0]);
            map.get(c)[1] = Math.max(i, map.get(c)[1]);
        }
        int[][] res = map.values().toArray(new int[0][0]);
        Arrays.sort(res, Comparator.comparingInt(o -> o[0]));

        List<Integer> ans = new ArrayList<>();
        int start = 0;
        int end = 0;
        for (int[] arr : res) {
            if (arr[0] <= end) {
                end = Math.max(end, arr[1]);
            } else {
                ans.add(end - start + 1);
                start = arr[0];
                end = arr[1];
            }
        }
        ans.add(end - start + 1);

        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.partitionLabels("abc"));
        System.out.println(s.partitionLabels("abcad"));
        System.out.println(s.partitionLabels("ababcbacadefegdehijhklij"));
    }
}
