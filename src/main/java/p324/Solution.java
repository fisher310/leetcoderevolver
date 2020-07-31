package p324;

import java.util.Arrays;

class Solution {

    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);

        int mid = nums.length % 2 == 1 ? nums.length / 2 + 1 : nums.length / 2;
        int[] A = new int[mid];
        int[] B = new int[nums.length - mid];
        System.arraycopy(nums, 0, A, 0, mid);
        System.arraycopy(nums, mid, B, 0, nums.length - mid);
        reverse(A);
        reverse(B);

        int j = 0;
        for (int i = 0; i < mid; i++) {
            nums[j++] = A[i];
            if (i < B.length) {
                nums[j++] = B[i];
            }
        }
    }

    private void reverse(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int tmp = nums[l];
            nums[l] = nums[r];
            nums[r] = tmp;
            l++;
            r--;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        int[] nums3 = new int[] {1, 1, 2, 1, 2, 2, 1};
        s.wiggleSort(nums3);
        System.out.println(Arrays.toString(nums3));

        int[] nums = new int[] {1, 5, 1, 1, 6, 4};
        s.wiggleSort(nums);
        System.out.println(Arrays.toString(nums));

        int[] nums2 = new int[] {1, 3, 2, 2, 3, 1};
        s.wiggleSort(nums2);
        System.out.println(Arrays.toString(nums2));
    }
}
