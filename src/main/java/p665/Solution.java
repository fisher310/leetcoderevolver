package p665;

class Solution {

    public boolean checkPossibility(int[] nums) {

        int cnt = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            int x = nums[i], y = nums[i + 1];
            if (x > y) {
                cnt++;
                if (cnt > 1) {
                    return false;
                }

                if (i > 0 && y < nums[i - 1]) {
                    nums[i + 1] = x;
                }
            }
        }
        return true;
    }
}
