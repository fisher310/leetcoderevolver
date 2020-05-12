package p811;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/** 子域名访问计数 */
class Solution {
  public List<String> subdomainVisits(String[] cpdomains) {
    Map<String, Integer> map = new HashMap<>();
    for (String cp : cpdomains) {
      String[] ss = cp.split(" ");
      String s = ss[1];
      int cnt = Integer.parseInt(ss[0]);
      map.put(s, map.getOrDefault(s, 0) + cnt);
      int first = s.indexOf('.');
      if (first > -1) {
        String s1 = s.substring(first + 1);
        map.put(s1, map.getOrDefault(s1, 0) + cnt);

        int second = s.indexOf('.', first + 1);
        if (second > 0) {
          String s2 = s.substring(second + 1);
          map.put(s2, map.getOrDefault(s2, 0) + cnt);
        }
      }
    }
    List<String> ans = new LinkedList<>();
    for (Map.Entry<String, Integer> entry : map.entrySet()) {
      ans.add(entry.getValue() + " " + entry.getKey());
    }
    return ans;
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println(s.subdomainVisits(new String[] {"9001 discuss.leetcode.com"}));

    System.out.println(
        s.subdomainVisits(
            new String[] {
              "900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"
            }));
  }
}
