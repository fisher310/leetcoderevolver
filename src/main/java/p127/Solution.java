package p127;

import java.util.*;

/** 单词接龙 */
class Solution {
  public int ladderLength(String beginWord, String endWord, List<String> wordList) {

    Map<String, List<String>> map = new HashMap<>();

    for (int i = 0; i < wordList.size(); i++) {
      for (int j = i + 1; j < wordList.size(); j++) {
        String word1 = wordList.get(i);
        String word2 = wordList.get(j);
        if (dis(word1, word2) == 1) {
          join(map, word1, word2);
          join(map, word2, word1);
        }
      }
    }

    boolean flag = map.containsKey(beginWord);
    if (!flag) {
      List<String> beginList = new LinkedList<>();
      for (String w : wordList) {
        if (dis(beginWord, w) == 1) {
          beginList.add(w);
        }
      }
      map.put(beginWord, beginList);
    }

    LinkedList<Node> queue = new LinkedList<>();

    queue.offer(new Node(1, map.get(beginWord)));
    Set<String> visited = new HashSet<>();
    visited.add(beginWord);

    while (!queue.isEmpty()) {
      Node node = queue.poll();
      if (node.list == null || node.list.size() == 0) {
        continue;
      }
      for (String w : node.list) {
        if (w.equals(endWord)) {
          return node.dis + 1;
        }
        if (!visited.contains(w)) {
          queue.offer(new Node(node.dis + 1, map.get(w)));
          visited.add(w);
        }
      }
    }

    return 0;
  }

  private void join(Map<String, List<String>> map, String word1, String word2) {
    if (map.containsKey(word1)) {
      List<String> w1l = map.get(word1);
      w1l.add(word2);
    } else {
      List<String> w1l = new LinkedList<>();
      w1l.add(word2);
      map.put(word1, w1l);
    }
  }

  private int dis(String a, String b) {
    int i = 0;
    int j = 0;
    int ans = 0;
    while (i < a.length() && j < b.length()) {
      if (a.charAt(i++) != b.charAt(j++)) {
        ans++;
      }
    }
    return ans;
  }

  private static class Node {
    int dis;
    List<String> list;

    Node(int dis, List<String> list) {
      this.dis = dis;
      this.list = list;
    }
  }
}
