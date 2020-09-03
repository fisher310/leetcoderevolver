package p448;

import java.util.ArrayList;
import java.util.List;

class Solution {

    public List<Integer> findDisappearedNumbers(int[] nums) {

        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            while (nums[i] - 1 != i && nums[nums[i]-1] != nums[i]) {
                // 把 num[i] 放到 i 的位置上去
//                swap(nums, nums[i] - 1, i);
                int tmp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = tmp;
            }

        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] - 1 != i) {
                ans.add(i + 1);
            }
        }

        return ans;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.findDisappearedNumbers(new int[]{4, 3, 2, 7, 8, 2, 3, 1}));
    }
}

