package week284.p01;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author lihailong
 * @since 2022-03-13 10:34:26
 */
public class Solution {

  public List<Integer> findKDistantIndices(int[] nums, int key, int k) {

    Set<Integer> ans = new HashSet<>();
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == key) {
        for (int j = Math.max(0, i - k); j <= Math.min(nums.length - 1, i + k); j++) {
          ans.add(j);
        }
      }
    }

    return ans.stream().sorted().collect(Collectors.toList());
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println(s.findKDistantIndices(new int[] {3, 4, 9, 1, 3, 9, 5}, 9, 1));
    System.out.println(s.findKDistantIndices(new int[] {2, 2, 2, 2, 2}, 2, 2));
  }
}
