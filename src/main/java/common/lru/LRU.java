package common.lru;


import java.util.HashMap;

public class LRU<K, V> {
  private int size;

  private int capacity;

  private HashMap<K, Node> caches;

  private Node first;
  private Node last;

  public LRU(int size) {
    this.capacity = size;
    this.size = 0;
    caches = new HashMap<>(capacity);
  }

  public LRU() {
    this(16);
  }

  public void put(K key, V value) {
    Node node = caches.get(key);
    if (node == null) {
      if (caches.size() >= capacity) {
        caches.remove(last.key);
        removeLast();
      }
      node = new Node(key, value);
    }
    node.value = value;
    moveToHead(node);
    caches.put(key, node);
    size++;
  }

  public Object get(K key) {
    Node node = caches.get(key);
    if (node == null) {
      return null;
    }
    moveToHead(node);
    return node.value;
  }

  public Object remove(K key) {
    Node node = caches.get(key);
    if (node != null) {
      if (node.pre != null) {
        node.pre.next = node.next;
      }
      if (node.next != null) {
        node.next.pre = node.pre;
      }
      if (node == first) {
        first = node.next;
      }
      if (node == last) {
        last = node.pre;
      }
    }
    size--;
    return caches.remove(key);
  }

  public void clear() {
    this.first = null;
    this.last = null;
    this.size = 0;
    this.caches.clear();
  }

  public int size() {
    return size;
  }

  private void moveToHead(Node node) {
    if (first == node) {
      return;
    }
    if (node.next != null) {
      node.next.pre = node.pre;
    }

    if (node.pre != null) {
      node.pre.next = node.next;
    }

    if (node == last) {
      last = node.pre;
    }

    if (first == null || last == null) {
      first = last = node;
      return;
    }
    node.next = first;
    first.pre = node;
    first = node;
    first.pre = null;
  }

  private void removeLast() {
    if (this.last == null) {
      return;
    }
    caches.remove(last.key);
    size--;
    if (this.first == last) {
      this.first = null;
      this.last = null;
      this.size = 0;
      return;
    }
    if (last.pre != null) {
      this.last.pre.next = null;
      last = last.pre;
    }
  }

  public static void main(String[] args) {
    LRU<String, String> cache = new LRU<>(3);
    cache.put("hello", "world");

    cache.put("foo", "bar");
    cache.put("name", "lilei");
    System.out.println(cache.get("name"));
    cache.put("king", "fisher");
    System.out.println(cache.get("foo"));
    System.out.println(cache.get("hello"));
  }
}
