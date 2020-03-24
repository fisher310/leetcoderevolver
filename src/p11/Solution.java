package p11;

/**
 * 数组，双指针 <br>
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i,
 *
 * <p>0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * <p>说明：你不能倾斜容器，且 n 的值至少为 2。
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/container-with-most-water
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {
    public int maxArea(int[] height) {
        int ans = 0;
        int l = 0, r = height.length - 1;
        while (l < r) {
            if (height[l] < height[r]) {
                int h = height[l];
                ans = Math.max(h * (r - l), ans);
                while (l < r && height[l] <= h) {
                    l++;
                }
            } else {
                int h = height[r];
                ans = Math.max(h * (r - l), ans);
                while (l < r && height[r] <= h) {
                    r--;
                }
            }
//            ans = Math.max(Math.min(height[l], height[r]) * (r - l), ans);
//            if (height[l] < height[r]) {
//                l++;
//            } else {
//                r--;
//            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }
}
