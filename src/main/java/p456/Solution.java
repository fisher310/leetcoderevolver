package p456;

class Solution {

    public boolean find132pattern(int[] nums) {

//        int min = Math.min(), max;

        for (int i = 0; i < nums.length; i++) {
            int a = nums[i];
            int b = nums[i + 1];
            int c = nums[i + 2];
            if (a < c && c < b) {
                return true;
            }
        }

        return false;
    }
}
