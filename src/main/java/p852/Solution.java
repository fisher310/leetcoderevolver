package p852;

import org.junit.Assert;

public class Solution {
  public int peakIndexInMountainArray(int[] arr) {
    int l = 0, r = arr.length;

    while (l < r) {
      int mid = l + (r - l) / 2;
      // System.out.println("l: " + l + ", r: " + r + ", mid: " + mid);
      if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) {
        return mid;
      } else if (arr[mid] > arr[mid - 1] && arr[mid] < arr[mid + 1]) {
        l = mid;
      } else if (arr[mid] < arr[mid - 1] && arr[mid] > arr[mid + 1]) {
        r = mid;
      }
    }

    return l;
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    Assert.assertEquals(2, s.peakIndexInMountainArray(new int[] {3, 5, 6, 5, 1, 0}));
    Assert.assertEquals(3, s.peakIndexInMountainArray(new int[] {3, 5, 6, 7, 0}));
    Assert.assertEquals(1, s.peakIndexInMountainArray(new int[] {3, 5, 3, 2, 0}));
    Assert.assertEquals(1, s.peakIndexInMountainArray(new int[] {0, 2, 1, 0}));
    Assert.assertEquals(1, s.peakIndexInMountainArray(new int[] {0, 10, 5, 2}));
    Assert.assertEquals(2, s.peakIndexInMountainArray(new int[] {3, 4, 5, 1}));
    Assert.assertEquals(
        2, s.peakIndexInMountainArray(new int[] {24, 69, 100, 99, 79, 78, 67, 36, 26, 191}));
  }
}
