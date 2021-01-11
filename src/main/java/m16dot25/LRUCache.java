package m16dot25;

import org.junit.Assert;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

class LRUCache {

    private final Map<Integer, Integer> cache;
    private final LinkedList<Integer> list;
    private final int capacity;

    public LRUCache(int capacity) {
        this.cache = new HashMap<>();
        this.list = new LinkedList<>();
        this.capacity = capacity;
    }

    public int get(int key) {
        int ret = cache.getOrDefault(key, -1);
        if (ret != -1) {
            list.remove(Integer.valueOf(key));
            list.addFirst(key);
        }
        return ret;
    }

    public void put(int key, int value) {
        if (cache.size() >= capacity && !cache.containsKey(key)) {
            Integer old = list.removeLast();
            cache.remove(old);
        }
        if (cache.containsKey(key)) {
            list.remove(Integer.valueOf(key));
        }
        list.addFirst(key);
        cache.put(key, value);
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2 /* 缓存容量 */);

        cache.put(1, 1);
        cache.put(2, 2);
        Assert.assertEquals(1, cache.get(1)); // 返回  1
        cache.put(3, 3); // 该操作会使得密钥 2 作废
        Assert.assertEquals(-1, cache.get(2)); // 返回 -1 (未找到)
        cache.put(4, 4); // 该操作会使得密钥 1 作废
        Assert.assertEquals(-1, cache.get(1)); // 返回 -1 (未找到)
        Assert.assertEquals(3, cache.get(3)); // 返回  3
        Assert.assertEquals(4, cache.get(4)); // 返回
    }
}
