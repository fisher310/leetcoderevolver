package p88;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;

public class SolutionTest {

  @Test
  public void merge() {
    Solution s = new Solution();
    int[] nums1 = new int[] {1, 2, 0, 0, 0, 0};
    int[] nums2 = new int[] {2, 5, 6};
    s.merge(nums1, 2, nums2, 3);
    System.out.println(Arrays.toString(nums1));
    assertArrayEquals(new int[] {1, 2, 2, 5, 6, 0}, nums1);

    int[] nums = new int[] {0};
    s.merge(nums, 0, new int[] {1}, 1);
    assertArrayEquals(new int[] {1}, nums);

    nums = new int[] {1};
    s.merge(nums, 1, new int[] {1}, 0);
    assertArrayEquals(new int[] {1}, nums);
  }
}
