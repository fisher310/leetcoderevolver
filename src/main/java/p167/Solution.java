package p167;

/** 两数之和 II - 输入有序数组 */
class Solution {
  public int[] twoSum(int[] numbers, int target) {
    int i = 0, j = numbers.length - 1;
    for (; i < j; ) {
      int sum = numbers[i] + numbers[j];
      if (sum == target) {
        return new int[] {i + 1, j + 1};
      } else if (sum < target) {
        i++;
      } else {
        j--;
      }
    }
    return null;
  }
}
