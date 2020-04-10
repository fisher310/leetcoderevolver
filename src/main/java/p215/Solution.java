package p215;

import java.util.Random;

/** 数组中第K个最大元素 */
class Solution {
  private Random random = new Random();

  public int findKthLargest(int[] nums, int k) {
    int N = nums.length;
    return nums[partition(nums, 0, N, k - 1)];
  }

  int partition(int[] nums, int start, int end, int k) {
    int rand = start + random.nextInt(end - start);
    int pivot = nums[rand];
    swap(nums, rand, start);
    int p1 = start;
    int p2 = end;
    for (int i = start + 1; i < p2; ) {
      if (nums[i] == pivot) {
        i++;
      } else if (nums[i] < pivot) {
        p2--;
        swap(nums, i, p2);
      } else {
        p1++;
        swap(nums, i, p1);
        i++;
      }
    }
    swap(nums, start, p1);
    if (p1 <= k && k < p2) return p1;
    else if (p2 <= k) return partition(nums, p2, end, k);
    else return partition(nums, start, p1, k);
  }

  private void swap(int[] nums, int i, int j) {
    if (i == j) return;
    int tmp = nums[i];
    nums[i] = nums[j];
    nums[j] = tmp;
  }
}
