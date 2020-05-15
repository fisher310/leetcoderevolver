package p1032;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 字符流
 */
class StreamChecker {

    TrieImp trie;

    StringBuilder history;

    public StreamChecker(String[] words) {
        trie = new TrieImp();
        history = new StringBuilder();

        for (String word : words) {
            trie.insert(word);
        }
    }

    public boolean query(char letter) {
        history.append(letter);
        return trie.search(history);
    }

    private static class TrieImp {

        public class TrieNode {
            TrieNode[] child;
            boolean end;

            public TrieNode() {
                child = new TrieNode[26];
                end = false;
            }
        }

        private final TrieNode root;

        public TrieImp() {
            this.root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode currentNode = root;
            for (int i = word.length() -1 ; i >= 0; i--) {
                TrieNode node = currentNode.child[word.charAt(i) - 'a'];
                if (node == null) {
                    node = new TrieNode();
                    currentNode.child[word.charAt(i) - 'a'] = node;
                }
                currentNode = node;
            }
            currentNode.end = true;
        }

        public boolean search(StringBuilder sb) {
            TrieNode currentNode = root;
            for (int i = sb.length() - 1; i >= 0; i--) {
                char ch = sb.charAt(i);
                TrieNode node = currentNode.child[ch - 'a'];
                if (node == null) {
                    return false;
                }
                if (node.end)
                    return true;
                currentNode = node;
            }
            return currentNode.end;
        }

    }

    public static void main(String[] args) throws IOException {

        List<String> lines =
                Files.readAllLines(
                        Paths.get(
                                "D:\\spaces\\github.com\\leetcodesolver\\src\\main\\java\\p1032\\words.txt"));
        List<String> words =
                Arrays.stream(lines.get(0).split(","))
                        .map(
                                s -> {
                                    return s.substring(1, s.length() - 1);
                                })
                        .collect(Collectors.toList());
        List<String> queryLine =
                Files.readAllLines(
                        Paths.get(
                                "D:\\spaces\\github.com\\leetcodesolver\\src\\main\\java\\p1032\\query.txt"));
        List<Character> queryList =
                Arrays.stream(queryLine.get(0).split(","))
                        .map(s -> s.charAt(2))
                        .collect(Collectors.toList());
        long start = System.currentTimeMillis();

        StreamChecker streamChecker = new StreamChecker(words.toArray(new String[] {}));
        for (char c : queryList) {
            streamChecker.query(c);
        }

        long duration = System.currentTimeMillis() - start;
        System.out.println("time duration: " + duration);

//        StreamChecker streamChecker = new StreamChecker(new String[] {"cd", "f", "kl"});
//        System.out.println(streamChecker.query('a')); // 返回 false
//        System.out.println(streamChecker.query('b')); // 返回 false
//        System.out.println(streamChecker.query('c')); // 返回 false
//        System.out.println(streamChecker.query('d')); // 返回 true，因为 'cd' 在字词表中
//        System.out.println(streamChecker.query('e')); // 返回 false
//        System.out.println(streamChecker.query('f')); // 返回 true，因为 'f' 在字词表中
//        System.out.println(streamChecker.query('g')); // 返回 false
//        System.out.println(streamChecker.query('h')); // 返回 false
//        System.out.println(streamChecker.query('i')); // 返回 false
//        System.out.println(streamChecker.query('j')); // 返回 false
//        System.out.println(streamChecker.query('k')); // 返回 false
//        System.out.println(streamChecker.query('l')); // 返回 true，因为 'kl' 在字词表中。
    }
}
