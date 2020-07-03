package common;

class TwoArray {

    public boolean existNum(int[][] nums, int target) {

        if (nums == null || nums.length == 0) return false;

        int row = nums.length;

        int col = nums[0].length;

        int l = 0, r = row;
        while (l < r) {

            int mid = l + (r - l) / 2;

            if (nums[mid][0] > target) {
                r = mid;
            } else if (nums[mid][0] <= target && nums[mid][col-1] >= target) {
                // may be in this row
                int left = 0, right = col;
                while (left < right) {
                    int m = left + (right - left) / 2;
                    if (nums[mid][m] == target) {
                        return true;
                    } else if (nums[mid][m] < target) {
                        left = m + 1;
                    } else {
                        right = m;
                    }
                }
                break;
            } else {
                l = mid + 1;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        TwoArray ta = new TwoArray();
        System.out.println(ta.existNum(new int[][] {{1, 2, 3}, {4, 5, 6}}, 8));
    }
}
