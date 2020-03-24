package p208;

import java.util.ArrayList;
import java.util.List;

/**
 * 实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。
 *
 * <p>示例:
 *
 * <p>Trie trie = new Trie();
 *
 * <p>trie.insert("apple"); <br>
 * trie.search("apple"); // 返回 true <br>
 * trie.search("app"); // 返回 false <br>
 * trie.startsWith("app"); // 返回 true <br>
 * trie.insert("app"); trie.search("app"); // 返回 true <br>
 * 说明:
 *
 * <p>你可以假设所有的输入都是由小写字母 a-z 构成的。 <br>
 * 保证所有输入均为非空字符串。
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/implement-trie-prefix-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Trie {

  static class TrieNode {
    List<TrieNode> children;
    boolean isEnd;
    Character value;

    TrieNode(Character c) {
      value = c;
      this.isEnd = false;
      children = new ArrayList<>();
    }
  }

  TrieNode root;

  /** Initialize your data structure here. */
  public Trie() {
    root = new TrieNode(null);
  }

  /** Inserts a word into the trie. */
  public void insert(String word) {
    char[] chars = word.toCharArray();
    TrieNode current = root;
    for (char c : chars) {
      TrieNode node = null;
      for (TrieNode n : current.children) {
        if (n.value == c) {
          node = n;
          break;
        }
      }
      if (node == null) {
        node = new TrieNode(c);
        current.children.add(node);
      }
      current = node;
    }
    current.isEnd = true;
  }

  /** Returns if the word is in the trie. */
  public boolean search(String word) {
    TrieNode current = root;
    char[] chars = word.toCharArray();
    outer:
    for (char c : chars) {
      for (TrieNode n : current.children) {
        if (n.value == c) {
          current = n;
          continue outer;
        }
      }
      return false;
    }
    return current.isEnd;
  }

  /** Returns if there is any word in the trie that starts with the given prefix. */
  public boolean startsWith(String prefix) {
    char[] chars = prefix.toCharArray();
    TrieNode current = root;
    outer:
    for (char c : chars) {
      for (TrieNode n : current.children) {
        if (n.value == c) {
          current = n;
          continue outer;
        }
      }
      return false;
    }
    return true;
  }

  /**
   * Your Trie object will be instantiated and called as such: <br>
   * Trie obj = new Trie(); obj.insert(word); <br>
   * boolean param_2 = obj.search(word); <br>
   * boolean param_3 = obj.startsWith(prefix);
   */
  public static void main(String[] args) {
    //
    Trie obj = new Trie();
    obj.insert("apple");
    System.out.println(obj.search("apple"));
    System.out.println(obj.search("app"));
    System.out.println(obj.startsWith("app"));
    obj.insert("app");
    System.out.println(obj.search("app"));
  }
}
