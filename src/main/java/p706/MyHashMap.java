package p706;

import java.util.*;

class MyHashMap {

    private static final int BASE = 769;
    private LinkedList<Entry>[] data;

    public MyHashMap() {
        this.data = new LinkedList[769];
        for (int i = 0; i < BASE; i++) {
            data[i] = new LinkedList<>();
        }
    }

    public void put(int key, int value) {
        int h = hash(key);
        Iterator<Entry> iterator = data[h].iterator();
        while (iterator.hasNext()) {
            Entry e = iterator.next();
            if (e.key == key) {
                e.value = value;
                return;
            }
        }
        data[h].offerLast(new Entry(key, value));
    }

    public int get(int key) {
        int h = hash(key);
        Iterator<Entry> iterator = data[h].iterator();
        while (iterator.hasNext()) {
            Entry e = iterator.next();
            if (e.key == key) {
                return e.value;
            }
        }
        return -1;
    }

    public void remove(int key) {
        int h = hash(key);
        Iterator<Entry> iterator = data[h].iterator();
        while (iterator.hasNext()) {
            Entry e = iterator.next();
            if (e.key == key) {
                iterator.remove();
                return;
            }
        }

    }

    private int hash(int key) {
        return key % BASE;
    }

    private static class Entry {
        private int key;
        private int value;

        Entry(int key, int value) {
            this.key = key;
            this.value = value;
        }
    
	}
}
