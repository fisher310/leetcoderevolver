package p611;

import java.util.Arrays;
import org.junit.Assert;

/**
 * 输入: [2,2,3,4] 输出: 3 解释: 有效的组合是: 2,3,4 (使用第一个 2) 2,3,4 (使用第二个 2) 2,2,3
 *
 * @author lihailong
 * @since 2021/08/04 10:34:18
 */
class Solution {

    public int triangleNumber(int[] nums) {
        int ans = 0;
        int n = nums.length;
        Arrays.sort(nums);

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int left = j + 1, right = n - 1, k = j;
                while (left <= right) {
                    int mid = left + (right - left) / 2;
                    if (nums[mid] < nums[i] + nums[j]) {
                        k = mid;
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                }
                ans += k - j;
            }
        }

        return ans;
    }

    private boolean isTriangle(int a, int b, int c) {
        return (a + b) > c && (b + c) > a && (a + c) > b;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        Assert.assertEquals(3, s.triangleNumber(new int[] {2, 2, 3, 4}));
    }
}
