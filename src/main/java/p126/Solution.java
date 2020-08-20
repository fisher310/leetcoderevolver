package p126;

import java.util.*;

class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {


        Queue<Integer> queue = new LinkedList<>();

        List<String> res = new ArrayList<>();
        List<List<String>> ans = new LinkedList<>();

        Set<String> visited = new HashSet<>();
        for (String word : wordList) {
            if (dis(beginWord, word)) {
                visited.clear();
                bfs(word, endWord, wordList, visited, new ArrayList<String>(), ans);
            }
        }

        return ans;
    }

    private void bfs(String word, String target, final List<String> wordList, Set<String> visited, List<String> res, List<List<String>> ans) {

        visited.add(word);

        for (String w : wordList) {
            if (visited.contains(w)) {
                continue;
            }

            if (dis(word, w));
        }


    }

    private boolean dis(String s1, String s2) {
        int dis = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                dis++;
                if (dis > 1) {
                    return false;
                }
            }
        }

        return dis == 1;
    }
}
