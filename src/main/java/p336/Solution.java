package p336;


import java.util.*;

class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> ans = new ArrayList<>();
        Map<String, Integer> reverseMap = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            reverseMap.put(reversed(words[i]), i);
        }

        for (int i = 0; i < words.length; i++) {
            String s = words[i];
            for (int j = 0; j <= s.length(); j++) {
                String subs = s.substring(j);
                if (j != 0 && isPalindrome(s, 0, j)
                        && reverseMap.containsKey(subs)
                        && reverseMap.get(subs) != i) {
                    ans.add(Arrays.asList(reverseMap.get(subs), i));
                }


                String subs2 = s.substring(0, j);
                if (isPalindrome(s, j , s.length())
                        && reverseMap.containsKey(subs2)
                        && reverseMap.get(subs2) != i) {
                    ans.add(Arrays.asList(i, reverseMap.get(subs2)));
                }

            }
        }

        return ans;
    }

    String reversed(String str) {
        char[] ch = str.toCharArray();
        int l = 0, r = ch.length - 1;
        while (l < r) {
            char tmp = ch[r];
            ch[r] = ch[l];
            ch[l] = tmp;
            l++;
            r--;
        }
        return new String(ch);
    }

    boolean isPalindrome(String s, int start, int end) {
        int i = start, j = end - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.palindromePairs(new String[]{"a", "abc", "aba", ""}));
        System.out.println(s.palindromePairs(new String[]{"abcd","dcba","lls","s","sssll"}));
        System.out.println(s.palindromePairs(new String[]{"a", ""}));
        System.out.println(s.palindromePairs(new String[]{"bat", "tab", "cat"}));
    }
}
