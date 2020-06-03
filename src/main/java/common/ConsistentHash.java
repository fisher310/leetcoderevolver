package common;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.SortedMap;
import java.util.UUID;
import java.util.concurrent.ConcurrentSkipListMap;

public class ConsistentHash {

    private SortedMap<Integer, String> treeMap;

    private int virtual;

    public ConsistentHash() {
        virtual = 160;
        treeMap = new ConcurrentSkipListMap<>();

        String[] machines = new String[] {"192.168.1.100", "192.168.1.101", "192.168.1.102"};
        for (String m : machines) {
            for (int i = 0; i < virtual; i++) {
                treeMap.put(getHash(m + "-N-" + i), m);
            }
        }
    }

    private int getHash(String s) {
//        return Math.abs(s.hashCode());
        try {
            MessageDigest md5 = MessageDigest.getInstance("md5");
            byte[] digest = md5.digest(s.getBytes(StandardCharsets.UTF_8));
            return Arrays.hashCode(digest);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return s.hashCode();
        }
    }

    public String getServer(String key) {
        int hash = getHash(key);
        SortedMap<Integer, String> subMap = treeMap.tailMap(hash);
        if (subMap.isEmpty()) {
            Integer act = treeMap.firstKey();
            return treeMap.get(act);
        } else {
            Integer act = subMap.firstKey();
            return subMap.get(act);
        }
    }

    public static void main(String[] args) {
        ConsistentHash ch = new ConsistentHash();
        for (int i = 0; i < 10; i++) {
            System.out.println(ch.getServer(UUID.randomUUID().toString()));
        }
    }
}
