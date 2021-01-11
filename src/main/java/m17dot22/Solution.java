package m17dot22;

import java.util.*;

/** beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"] */
class Solution {
    List<String> ans;

    int min = 0;

    Map<String, List<String>> map;

    public List<String> findLadders(String beginWord, String endWord, List<String> wordList) {

        Set<String> dic = new HashSet<>(wordList);
        if (!dic.contains(endWord)) return Collections.emptyList();
        map = new HashMap<>();
        boolean found = bfs(beginWord, endWord, dic, map);
        if (!found) return Collections.emptyList();

        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        ArrayList<String> list = new ArrayList<>();
        list.add(beginWord);

        return dfs(beginWord, endWord, visited, 0, list) ? ans : Collections.emptyList();
    }

    private boolean bfs(
            String beginWord, String endWord, Set<String> dic, Map<String, List<String>> map) {
        Set<String> visited = new HashSet<>();

        Set<String> beginSet = new HashSet<>();
        beginSet.add(beginWord);

        Set<String> endSet = new HashSet<>();
        endSet.add(endWord);

        boolean forward = true;
        boolean found = false;
        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            min++;
            if (beginSet.size() > endSet.size()) {
                Set<String> tmp = beginSet;
                beginSet = endSet;
                endSet = tmp;
                forward = !forward;
            }

            Set<String> nextLevelSet = new HashSet<>();
            for (String word : beginSet) {

                char[] ch = word.toCharArray();

                for (int i = 0; i < ch.length; i++) {
                    char tmp = ch[i];
                    for (int c = 'a'; c <= 'z'; c++) {
                        if (ch[i] == c) continue;
                        ch[i] = (char) c;
                        String nextWord = new String(ch);
                        if (endSet.contains(nextWord)) {
                            found = true;
                            addSuccessor(word, nextWord, forward, map);
                        }

                        if (!visited.contains(nextWord) && dic.contains(nextWord)) {
                            nextLevelSet.add(nextWord);
                            addSuccessor(word, nextWord, forward, map);
                        }
                    }
                    ch[i] = tmp;
                }
            }
            if (found) break;
            beginSet = nextLevelSet;
            visited.addAll(nextLevelSet);
        }

        return found;
    }

    private void addSuccessor(String a, String b, boolean forward, Map<String, List<String>> map) {
        if (!forward) {
            String tmp = a;
            a = b;
            b = tmp;
        }

        map.computeIfAbsent(a, (s) -> new ArrayList<>());
        map.get(a).add(b);
    }

    private boolean dfs(
            String beginWord, String endWord, Set<String> visited, int level, List<String> curr) {
        if (beginWord.equals(endWord)) {
            ans = new ArrayList<>(curr);
            return true;
        }
        if (level > min) return false;

        for (String s : map.getOrDefault(beginWord, Collections.emptyList())) {
            if (!visited.contains(s)) {
                visited.add(s);
                curr.add(s);
                if (dfs(s, endWord, visited, level + 1, curr)) {
                    return true;
                }
                visited.remove(s);
                curr.remove(curr.size() - 1);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.findLadders("a", "c", Arrays.asList("a", "b", "c")));
        List<String> ans =
                s.findLadders(
                        "hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log", "cog"));
        System.out.println(ans);
    }
}
