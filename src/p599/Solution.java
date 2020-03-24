package p599;

import java.util.*;

class Solution {
  public String[] findRestaurant(String[] list1, String[] list2) {
    /*    int min = Integer.MAX_VALUE;
    Set<String> result = new HashSet<>();

    for (int i = 0; i < list1.length; i++) {
      for (int j = 0; j < list2.length; j++) {
        if (list1[i].equals(list2[j])) {
          int indexSum = i + j;
          if (indexSum < min) {
            result.clear();
            min = indexSum;
            result.add(list1[i]);
          } else if (indexSum == min) {
            result.add(list1[i]);
          }
        }
      }
    }

    return result.toArray(new String[] {});*/

    int minIndex = Integer.MAX_VALUE;
    Set<String> result = new HashSet<>();
    Map<String, Integer> map = new HashMap<>();
    for (int i = 0; i < list1.length; i++) {
      map.put(list1[i], i);
    }

    for (int j = 0; j < list2.length; j++) {
      Integer index1 = map.get(list2[j]);
      if (null != index1) {
        int newIndex = index1 + j;
        if (newIndex < minIndex) {
          result.clear();
          result.add(list2[j]);
          minIndex = newIndex;
        } else if (newIndex == minIndex) {
          result.add(list2[j]);
        }
      }
    }
    return result.toArray(new String[] {});
  }

  public static void main(String[] args) {
    //    String[] list1 = new String[] {"Shogun", "Tapioca Express", "Burger King", "KFC"};
    //    String[] list2 =
    //        new String[] {"Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse",
    // "Shogun"};

    String[] list1 = new String[] {"Shogun", "Tapioca Express", "Burger King", "KFC"};
    String[] list2 = new String[] {"KFC", "Shogun", "Burger King"};

    String[] result = new Solution().findRestaurant(list1, list2);

    System.out.println(Arrays.toString(result));
  }
}
