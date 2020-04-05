package p460;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LFUCacheTest {

  @Test
  public void get() {
    LFUCache cache = new LFUCache(3);
    cache.put(2, 2);
    cache.put(1, 1);
    assertEquals(2, cache.get(2));
    assertEquals(1, cache.get(1));
    assertEquals(2, cache.get(2));
    cache.put(3, 3);
    cache.put(4, 4);
    assertEquals(-1, cache.get(3));
    assertEquals(2, cache.get(2));
    assertEquals(4, cache.get(4));
  }

  @Test
  public void put() {
    LFUCache cache = new LFUCache(2);
    cache.put(1, 1);
    cache.put(2, 2);
    assertEquals(1, cache.get(1));
    cache.put(3, 3);
    assertEquals(-1, cache.get(2));
    assertEquals(3, cache.get(3));
    cache.put(4, 4);
    assertEquals(-1, cache.get(1));
    assertEquals(3, cache.get(3));
    assertEquals(4, cache.get(4));
  }

  @Test
  public void test3() {
    LFUCache cache = new LFUCache(0);
    cache.put(0, 0);
    assertEquals(-1, cache.get(0));
  }
}
