package p127;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/** 单词接龙 */
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        return bfs(beginWord, endWord, new HashSet<>(wordList));
    }

    private int bfs(String beginWord, String endWord, Set<String> wordList) {

        if (!wordList.contains(endWord)) return 0;

        Set<String> beginSet = new HashSet<>();
        beginSet.add(beginWord);
        Set<String> endSet = new HashSet<>();
        endSet.add(endWord);

        int len = 0;
        Set<String> visited = new HashSet<>();
        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            len++;

            if (beginSet.size() > endSet.size()) {
                Set<String> tmp = beginSet;
                beginSet = endSet;
                endSet = tmp;
            }
            Set<String> levelVisited = new HashSet<>();

            for (String word : beginSet) {
                char[] ch = word.toCharArray();
                for (int i = 0; i < ch.length; i++) {
                    char old = ch[i];
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == old) continue;
                        ch[i] = c;
                        String nextWord = new String(ch);
                        if (wordList.contains(nextWord)) {
                            if (endSet.contains(nextWord)) {
                                return len + 1;
                            }

                            if (!visited.contains(nextWord)) {
                                levelVisited.add(nextWord);
                            }
                        }
                    }
                    ch[i] = old;
                }
            }

            beginSet = levelVisited;

            visited.addAll(levelVisited);
        }

        return 0;
    }
}
