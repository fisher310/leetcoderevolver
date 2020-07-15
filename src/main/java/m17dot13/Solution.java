package m17dot13;

class Solution {

    public int respace(String[] dictionary, String sentence) {

        Trie trie = new Trie();

        for (String dic : dictionary) {
            trie.insert(dic);
        }

        for(int i = 0; i < sentence.length(); i++) {
            
        }
        return 0;
    }

    private static class Trie {

        TrieNode root;

        Trie() {
            this.root = new TrieNode();
        }

        void insert(String str) {
            TrieNode curr = root;
            for (int i = 0; i < str.length(); i++) {
                char v = str.charAt(i);
                TrieNode node = curr.children[v - 'a'];
                if (node == null) {
                    node = new TrieNode();
                    curr.children[v - 'a'] = node;
                }
                curr = node;
            }
            curr.isEnd = true;
        }

        boolean search(String str) {
            TrieNode curr = root;
            for (int i = 0; i < str.length(); i++) {
                char v = str.charAt(i);
                TrieNode node = curr.children[v - 'a'];
                if (node == null) {
                    return false;
                }
                curr = node;
            }
            return curr.isEnd;
        }

        boolean prefix(String str)  {
            TrieNode curr = root;
            for (int i = 0; i < str.length(); i++) {
                char v = str.charAt(i);
                TrieNode node = curr.children[v - 'a'];
                if (node == null) {
                    return false;
                }
                curr = node;
            }
            return true;
        }
    }

    private static class TrieNode {
        TrieNode[] children;
        boolean isEnd;

        TrieNode() {
            this.children = new TrieNode[26];
        }
    }

}