package p410;

/** 分割数组的最大值 */
class Solution {

    public int splitArray(int[] nums, int m) {

        long l = 0;
        long r = 0;
        for (int i = 0; i < nums.length; i++) {
            r += nums[i];
            if (l < nums[i]) {
                l = nums[i];
            }
        }


        long ans = r;
        while (l <= r) {
            long mid = l + (r - l) / 2;
            // 将数组分层m份，最大值是mid
            int cnt = 0;
            long sum = 0;
            for (int i = 0; i < nums.length; i++) {
                if (sum + nums[i] > mid) {
                    // 分割数组
                    cnt++;
                    sum = nums[i];
                } else {
                    sum += nums[i];
                }
            }

            if (sum > 0) cnt++;

            if (cnt <= m) {
                // 分成了小于m分且最大值不超过mid, 说明
                ans = Math.min(ans, mid);
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return (int) ans;
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.splitArray(new int[] {1, 2147483647}, 2));
        System.out.println(s.splitArray(new int[] {7, 2, 5, 10, 8}, 3));
    }
}
