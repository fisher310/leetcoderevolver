package m0710;

import java.util.*;

class Solution3 {

  public int findMinArrowShots(int[][] points) {
    TreeSet<Boll> treeSet = new TreeSet<>((o1, o2) -> {

      int c1 = Integer.compare(o1.right, o2.right);
      return c1 == 0 ? Integer.compare(o1.left, o2.left) : c1;
    });

    Map<Integer, Set<Boll>> map = new HashMap<>();
    for (int i = 0; i < points.length; i++) {
      int[] p = points[i];
      treeSet.add(new Boll(p[0], p[1]));
    }

    for (Boll a : treeSet) {
      for (Boll b : treeSet) {
        if (a == b) continue;
        if (b.left <= a.right && a.right <= b.right) {
          if (map.containsKey(a.right)) {
            Set<Boll> list = map.get(a.right);
            list.add(b);
          } else {
            Set<Boll> list = new HashSet<>();
            list.add(b);
            list.add(a);
            map.put(a.right, list);
          }
        }
      }
    }

    int ans = 0;
    while (!treeSet.isEmpty()) {
      ans++;
      Boll b = treeSet.pollFirst();
      Set<Boll> lb = map.get(b.right);
      if (lb != null) {
        for (Boll lbb : lb) {
          treeSet.remove(lbb);
        }
      }
    }

    return ans;
  }

  static class Boll {
    int left;
    int right;

    Boll(int _left, int _right) {
      this.left = _left;
      this.right = _right;
    }
  }

  public static void main(String[] args) {
    Solution3 s = new Solution3();
    System.out.println(
        s.findMinArrowShots(
            new int[][] {
              {0, 9}, {1, 8}, {7, 8}, {1, 6}, {9, 16}, {7, 13}, {7, 10}, {6, 11}, {6, 9}, {9, 13}
            }));
    System.out.println(s.findMinArrowShots(new int[][] {{10, 16}, {2, 8}, {1, 6}, {7, 12}}));
  }
}
