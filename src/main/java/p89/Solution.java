package p89;

import java.util.ArrayList;
import java.util.List;

/** 格雷编码 */
class Solution {

  // 镜像反射法
  public List<Integer> grayCode(int n) {
    List<Integer> res = new ArrayList<>();
    res.add(0);
    int head = 1;
    for (int i = 0; i < n; i++) {
      for (int j = res.size() - 1; j >= 0; j--) {
        res.add(head + res.get(j));
      }
      head = head << 1;
    }

    return res;
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    List<Integer> ans = s.grayCode(3);
    System.out.println(ans);
  }
}
