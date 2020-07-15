package p1207;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {

  public boolean uniqueOccurrences(int[] arr) {

    Map<Integer, Integer> map = new HashMap<>();
    for (int i : arr) {
        map.put(i, map.getOrDefault(i, 0) + 1);
    }

    Set<Integer> values = new HashSet<>();

    for (int c : map.values()) {
      if (values.contains(c)) {
        return false;
      }
      values.add(c);
    }

    return true;
  }
}
