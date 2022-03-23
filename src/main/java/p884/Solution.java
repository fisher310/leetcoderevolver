package p884;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {

        String[] arr1 = s1.split("\\s+");
        String[] arr2 = s2.split("\\s+");
        Map<String, Integer> map1 = new HashMap<>();
        for (String s : arr1) {
            map1.put(s, map1.getOrDefault(s, 0) + 1);
            map1.put(s, map1.getOrDefault(s, 0) + 1);
        }
        Map<String, Integer> map2 = new HashMap<>();
        for (String s : arr2) {
            map2.put(s, map2.getOrDefault(s, 0) + 1);
        }

        Set<String> set = new HashSet<>();
        for (Map.Entry<String, Integer> en : map1.entrySet()) {
            if (en.getValue() == 1 && !map2.containsKey(en.getKey())) {
                set.add(en.getKey());
            }
        }

        for (Map.Entry<String, Integer> en : map2.entrySet()) {
            if (en.getValue() == 1 && !map1.containsKey(en.getKey())) {
                set.add(en.getKey());
            }
        }

        return set.toArray(new String[] {});
    }
}