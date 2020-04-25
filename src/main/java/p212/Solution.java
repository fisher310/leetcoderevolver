package p212;

import java.util.*;

/**
 * 给定一个二维网格 board 和一个字典中的单词列表 words，找出所有同时在二维网格和字典中出现的单词。
 *
 * <p>单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母在一个单词中不允许被重复使用。
 *
 * <p>示例:
 *
 * <p>输入: words = ["oath","pea","eat","rain"] and board = [ ['o','a','a','n'], ['e','t','a','e'],
 * ['i','h','k','r'], ['i','f','l','v'] ]
 *
 * <p>输出: ["eat","oath"] 说明: 你可以假设所有输入都由小写字母 a-z 组成。
 *
 * <p>提示:
 *
 * <p>你需要优化回溯算法以通过更大数据量的测试。你能否早点停止回溯？ 如果当前单词不存在于所有单词的前缀中，则可以立即停止回溯。什么样的数据结构可以有效地执行这样的操作？散列表是否可行？为什么？
 * 前缀树如何？如果你想学习如何实现一个基本的前缀树，请先查看这个问题： 实现Trie（前缀树）。
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/word-search-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {
    private Set<String> ans;

    private int[] dx = {1, 0, -1, 0};
    private int[] dy = {0, 1, 0, -1};
    private int row;
    private int col;
    private Trie trie;

    public List<String> findWords(char[][] board, String[] words) {
        if (board == null || board.length == 0) return Collections.emptyList();

        ans = new LinkedHashSet<>();
        trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }
        row = board.length;
        col = board[0].length;
        boolean[][] visited = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                dfs(board, i, j, visited, "");
            }
        }

        return new ArrayList<>(ans);
    }

    private void dfs(char[][] grid, int i, int j, boolean[][] visited, String s) {
        if (i < 0 || i >= row || j < 0 || j >= col || visited[i][j]) return;

        visited[i][j] = true;
        String ss = s + grid[i][j];

        if (!trie.startsWith(ss)) {
            visited[i][j] = false;
            return;
        }
        if (trie.contains(ss)) {
            ans.add(ss);
        }

        for (int k = 0; k < 4; k++) {
            int x = i + dx[k];
            int y = j + dy[k];
            dfs(grid, x, y, visited, ss);
        }
        visited[i][j] = false;
    }

    private static class Trie {

        private final TrieNode root;

        Trie() {
            this.root = new TrieNode((char) 0);
        }

        void insert(String s) {
            TrieNode cur = root;
            for (char c : s.toCharArray()) {
                TrieNode n = null;
                for (TrieNode node : cur.children) {
                    if (node.value == c) {
                        n = node;
                        break;
                    }
                }
                if (n == null) {
                    n = new TrieNode(c);
                    cur.addChild(n);
                }
                cur = n;
            }
            cur.isEnd = true;
        }

        boolean contains(String s) {
            TrieNode cur = root;
            outer:
            for (char c : s.toCharArray()) {
                for (TrieNode node : cur.children) {
                    if (node.value == c) {
                        cur = node;
                        continue outer;
                    }
                }
                return false;
            }
            return cur.isEnd;
        }

        boolean startsWith(String prefix) {
            TrieNode cur = root;
            outer:
            for (char c : prefix.toCharArray()) {
                for (TrieNode node : cur.children) {
                    if (node.value == c) {
                        cur = node;
                        continue outer;
                    }
                }
                return false;
            }
            return true;
        }

        private static class TrieNode {
            char value;
            List<TrieNode> children;
            boolean isEnd;

            TrieNode(char c) {
                this.value = c;
                this.children = new ArrayList<>();
                this.isEnd = false;
            }

            void addChild(TrieNode child) {
                this.children.add(child);
            }
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        //        System.out.println(s.findWords(new char[][] {{'a', 'a'}}, new String[] {"aaa"}));
        //        System.out.println(
        //                s.findWords(
        //                        new char[][] {
        //                            {'o', 'a', 'a', 'n'},
        //                            {'e', 't', 'a', 'e'},
        //                            {'i', 'h', 'k', 'r'},
        //                            {'i', 'f', 'l', 'v'}
        //                        },
        //                        new String[] {"oath", "pea", "eat", "rain"}));
        //        long start = System.currentTimeMillis();
        //        List<String> words =
        //                s.findWords(
        //                        new char[][] {
        //                            {'b', 'b', 'a', 'a', 'b', 'a'},
        //                            {'b', 'b', 'a', 'b', 'a', 'a'},
        //                            {'b', 'b', 'b', 'b', 'b', 'b'},
        //                            {'a', 'a', 'a', 'b', 'a', 'a'},
        //                            {'a', 'b', 'a', 'a', 'b', 'b'}
        //                        },
        //                        new String[] {"abbbababaa"});
        //        long duration = System.currentTimeMillis() - start;
        //        System.out.println(words);
        //        System.out.println("duration: " + duration);

        System.out.println(
                s.findWords(
                        new char[][] {
                            {'b', 'a', 'a', 'b', 'a', 'b'},
                            {'a', 'b', 'a', 'a', 'a', 'a'},
                            {'a', 'b', 'a', 'a', 'a', 'b'},
                            {'a', 'b', 'a', 'b', 'b', 'a'},
                            {'a', 'a', 'b', 'b', 'a', 'b'},
                            {'a', 'a', 'b', 'b', 'b', 'a'},
                            {'a', 'a', 'b', 'a', 'a', 'b'}
                        },
                        new String[] {
                            "aab",
                            "bbaabaabaaaaabaababaaaaababb",
                            "aabbaaabaaabaabaaaaaabbaaaba",
                            "babaababbbbbbbaabaababaabaaa",
                            "bbbaaabaabbaaababababbbbbaaa",
                            "babbabbbbaabbabaaaaaabbbaaab",
                            "bbbababbbbbbbababbabbbbbabaa",
                            "babababbababaabbbbabbbbabbba",
                            "abbbbbbaabaaabaaababaabbabba",
                            "aabaabababbbbbbababbbababbaa",
                            "aabbbbabbaababaaaabababbaaba",
                            "ababaababaaabbabbaabbaabbaba",
                            "abaabbbaaaaababbbaaaaabbbaab",
                            "aabbabaabaabbabababaaabbbaab",
                            "baaabaaaabbabaaabaabababaaaa",
                            "aaabbabaaaababbabbaabbaabbaa",
                            "aaabaaaaabaabbabaabbbbaabaaa",
                            "abbaabbaaaabbaababababbaabbb",
                            "baabaababbbbaaaabaaabbababbb",
                            "aabaababbaababbaaabaabababab",
                            "abbaaabbaabaabaabbbbaabbbbbb",
                            "aaababaabbaaabbbaaabbabbabab",
                            "bbababbbabbbbabbbbabbbbbabaa",
                            "abbbaabbbaaababbbababbababba",
                            "bbbbbbbabbbababbabaabababaab",
                            "aaaababaabbbbabaaaaabaaaaabb",
                            "bbaaabbbbabbaaabbaabbabbaaba",
                            "aabaabbbbaabaabbabaabababaaa",
                            "abbababbbaababaabbababababbb",
                            "aabbbabbaaaababbbbabbababbbb",
                            "babbbaabababbbbbbbbbaabbabaa"
                        }));

        // ["aab","aabbbbabbaababaaaabababbaaba","abaabbbaaaaababbbaaaaabbbaab","ababaababaaabbabbaabbaabbaba"]
    }
}
