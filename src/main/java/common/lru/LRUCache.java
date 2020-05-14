package common.lru;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class LRUCache<K, V> extends LinkedHashMap<K, V> {

    private final int maxSize;
    private AtomicInteger total;
    private AtomicInteger hits;

    public LRUCache(int maxSize) {
        this(maxSize, 16, 0.75F, true);
    }

    public LRUCache(int maxSize, int initialCapacity, float loadFactor, boolean accessOrder) {
        super(initialCapacity, loadFactor, accessOrder);
        this.maxSize = maxSize;
        this.total = new AtomicInteger(0);
        hits = new AtomicInteger(0);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > this.maxSize;
    }

    @Override
    public V get(Object key) {
        total.incrementAndGet();
        V result = super.get(key);
        if (result != null) {
            hits.incrementAndGet();
        }
        return result;
    }

    public double hitsRate() {
        return hits.get()/(double)total.get();
    }

    public static void main(String[] args) {
        LRUCache<String, String> cache = new LRUCache<>(3);
        cache.put("hello", "world");
        cache.put("world", "hello");
        System.out.println(cache.get("hello"));
        cache.put("name", "fisher");
        cache.put("fisher", "name");
        System.out.println(cache.get("hello"));
        System.out.println(cache.get("world"));
        cache.put("dial", "nummber");

        System.out.println(cache.hitsRate());
    }
}
