package p1002;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

    public List<String> commonChars(String[] A) {

        int[] arr = new int[26];
        Arrays.fill(arr, 1000);
        for (String s : A) {
            int[] tmp = new int[26];
            for (int i = 0; i < s.length(); i++) {
                tmp[s.charAt(i) - 'a']++;
            }
            for (int i = 0; i < 26; i++) {
                arr[i] = Math.min(arr[i], tmp[i]);
            }
        }

        List<String> ans = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            while (arr[i]-- > 0) {
                ans.add(String.valueOf((char)(i + 'a')));
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Solution s =new Solution();
        List<String> ans = s.commonChars(new String[]{"bella", "label", "roller"});
        System.out.println(ans);
        System.out.println(s.commonChars(new String[]{"abcab"}));
    }
}
