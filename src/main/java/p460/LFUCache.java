package p460;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/** LFU缓存 */
class LFUCache {
  private int size;

  private int capacity;

  private Map<Integer, CacheNode> cache;

  TreeSet<CacheNode> treeSet;

  private int times = 0;

  public LFUCache(int capacity) {
    this.size = 0;
    this.capacity = capacity;
    this.cache = new HashMap<>();
    this.treeSet =
        new TreeSet<>(
            new Comparator<CacheNode>() {
              @Override
              public int compare(CacheNode o1, CacheNode o2) {
                if (o1.cnt == o2.cnt) {
                  return o1.time - o2.time;
                }
                return o1.cnt - o2.cnt;
              }
            });
  }

  public int get(int key) {
    CacheNode node = cache.get(key);
    if (node != null) {
      treeSet.remove(node);
      node.incr(times++);
      treeSet.add(node);
      return node.val;
    }
    return -1;
  }

  public void put(int key, int value) {
    if (this.capacity == 0) return;
    CacheNode n = cache.get(key);
    if (n != null) {
      treeSet.remove(n);
      n.incr(times);
      n.val = value;
      treeSet.add(n);
    } else {
      if (size == capacity) {
        CacheNode cacheNode = treeSet.pollFirst();
        cache.remove(cacheNode.key);
        size--;
      }
      CacheNode e = new CacheNode(key, value, times++);
      cache.put(key, e);
      treeSet.add(e);
      size++;
    }
  }

  static class CacheNode {
    int val;
    int cnt;
    int time;
    int key;

    CacheNode(int _key, int _val, int time) {
      this.key = _key;
      this.val = _val;
      this.time = time;
      this.cnt = 0;
    }

    void incr(int time) {
      this.time = time;
      this.cnt++;
    }
  }
}
