package p33;

/** 搜索旋转排序数组 */
class Solution {
  int pMax;
  int pMin;

  public int search(int[] nums, int target) {
    findMaxMin(nums, 0, nums.length-1);
    System.out.println(pMax + "," + pMin);
    return 0;
  }

  void findMaxMin(int[] nums, int left, int right) {
    if (left > right) return;
    int mid = left + (right - left) / 2;
    if (nums[left] > nums[mid]) {
      findMaxMin(nums, left, mid);
    } else {
      findMaxMin(nums, mid + 1, right);
    }
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    int[] input = {4, 5, 6, 7, 0, 1, 2};
    s.search(input, 0);
  }
}
