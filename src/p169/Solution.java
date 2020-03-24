package p169;

class Solution {
  public int majorityElement(int[] nums) {
    Integer major = null, count = 0;
    for (int num : nums) {
      if (major != null && num == major) {
        count++;
      } else if (count == 0) {
        major = num;
        count++;
      } else {
        count--;
      }
    }
    return major == null ? 0 : major;
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    int majority = s.majorityElement(new int[] {1, 2, 1, 3, 1, 1, 2, 1, 5});
    System.out.println(majority);
  }
}
