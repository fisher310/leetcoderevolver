package p49;

import java.util.*;

/** 字母异位词分组 */
class Solution {
  public List<List<String>> groupAnagrams(String[] strs) {

    Map<String, List<String>> map = new HashMap<>();
    for (String s : strs) {
      char[] arr = s.toCharArray();
      Arrays.sort(arr);
      String key = new String(arr);
      if (map.containsKey(key)) {
        map.get(key).add(s);
      } else {
        List<String> list = new LinkedList<>();
        list.add(s);
        map.put(key, list);
      }
    }

    return new ArrayList<>(map.values());
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    List<List<String>> ans =
        s.groupAnagrams(new String[] {"eat", "tea", "tan", "ate", "nat", "bat"});
    System.out.println(ans);
  }
}
