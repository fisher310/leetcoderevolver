package p88;

/** 合并两个有序数组 */
class Solution {
  public void merge(int[] nums1, int m, int[] nums2, int n) {
    int i = 0, j = 0;
    while (i < m && j < n) {
      if (nums1[i] <= nums2[j]) {
        i++;
      } else {
        int k = m - 1;
        while (k >= i) nums1[k + 1] = nums1[k--];
        nums1[i] = nums2[j++];
        m++;
      }
    }

    while (j < n) {
      nums1[i++] = nums2[j++];
    }
  }
}
