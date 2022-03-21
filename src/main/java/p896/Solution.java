package p896;

public class Solution {

  public boolean isMonotonic(int[] nums) {

    if (nums.length == 1) return true;

    boolean asc = false;
    boolean des = false;
    for (int i = 1; i < nums.length; i++) {
      if (nums[i] > nums[i - 1]) {
        asc = true;
      } else if (nums[i] < nums[i - 1]) {
        des = true;
      }
      if (asc && des) {
        return false;
      }
    }

    return true;
  }
}
