package week283.p04;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lihailong
 * @since 2022-03-06 11:28:34
 */
class Solution {

  public List<Integer> replaceNonCoprimes(int[] nums) {
    int N = nums.length - 1;

    int min = 0;
    for (int i = 0; i <= N; i++) {
      while (i > 0 && nums[i - 1] > 0) {
        int g = gcd(nums[i - 1], nums[i]);
        if (g > 1) {
          nums[i] = nums[i - 1] / g * nums[i];
          if (min < i - 1) {
            System.arraycopy(nums, min, nums, min + 1, (i - 1 - min));
          }
          nums[min] = 0;
          min++;
        } else {
          break;
        }
      }
    }

    List<Integer> ans = new ArrayList<>();
    for (int num : nums) {
      if (num > 0) {
        ans.add(num);
      }
    }
    return ans;
  }

  int gcd(int n, int m) {
    while (m != 0) {
      if (m < n) {
        int tmp = m;
        m = n;
        n = tmp;
      }
      m = m % n;
    }

    return n;
  }

  int lcm(int n, int m) {
    int g = gcd(n, m);
    return m / g * n;
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println(s.replaceNonCoprimes(new int[] {517, 11, 121, 517, 3, 51, 3, 1887, 5}));
    System.out.println(s.replaceNonCoprimes(new int[] {2, 2, 1, 1, 3, 3, 3}));
    System.out.println(s.replaceNonCoprimes(new int[] {6, 4, 3, 2, 7, 6, 2}));
  }
}
