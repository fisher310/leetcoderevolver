package p211;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lihailong
 * @since 2021/04/12 20:19:46
 */
class WordDictionary {

    private final TrieNode root;

    /**
     * Initialize your data structure here.
     */
    public WordDictionary() {
        root = new TrieNode((char) 0);
    }

    public void addWord(String word) {
        Map<Character, TrieNode> children = root.children;
        TrieNode node = null;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            node = children.get(c);
            if (node == null) {
                node = new TrieNode(c);
                children.put(c, node);
            } else {
                node = children.get(c);
            }
            children = node.children;
        }
        node.end = true;
    }

    public boolean search(String word) {
        return doSearch(word.toCharArray(), 0, root.children);
    }

    private boolean doSearch(char[] arr, int i, Map<Character, TrieNode> map) {
        if (arr[i] == '.') {
            for (char c : map.keySet()) {
                TrieNode node = map.get(c);
                if (node == null) return false;
                if (i == arr.length - 1) {
                    return node.end;
                }
                if (doSearch(arr, i + 1, node.children)) {
                    return true;
                }
            }
            return false;
        } else {
            TrieNode node = map.get(arr[i]);
            if (node == null) {
                return false;
            }
            if (i == arr.length - 1) {
                return node.end;
            }
            return doSearch(arr, i + 1, node.children);
        }
    }

    private static class TrieNode {

        char c;
        boolean end;
        Map<Character, TrieNode> children;

        TrieNode(char c) {
            this.c = c;
            this.children = new HashMap<>();
            this.end = false;
        }
    }

    public static void main(String[] args) {
        WordDictionary obj = new WordDictionary();
        obj.addWord("a");
        obj.addWord("a");
        System.out.println(obj.search(".a"));
        System.out.println(obj.search("."));
        System.out.println(obj.search("a"));
        System.out.println(obj.search("aa"));
        System.out.println(obj.search("a."));
    }
}
