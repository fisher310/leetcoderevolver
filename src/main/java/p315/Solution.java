package p315;

import java.util.*;

/** 计算右侧小于当前元素的个数 */
class Solution {

    public List<Integer> countSmaller(int[] nums) {

        int[] sorted = Arrays.stream(nums).distinct().sorted().toArray();

        Map<Integer, Integer> map = new HashMap<>(sorted.length);
        int rank = 0;
        for (int n : sorted) {
            map.put(n, ++rank);
        }

        FenwickTree ft = new FenwickTree(sorted.length);

        List<Integer> list = new ArrayList<>(nums.length);
        for (int i = nums.length - 1; i >= 0; i--) {
            list.add(ft.query(map.get(nums[i]) - 1));
            ft.update(map.get(nums[i]), 1);
        }

        Collections.reverse(list);

        return list;
    }

    static class FenwickTree {

        int[] bit;

        FenwickTree(int n) {
            bit = new int[n + 1];
        }

        void update(int i, int delta) {
            while (i < bit.length) {
                bit[i] += delta;
                i += lowbit(i);
            }
        }

        int query(int i) {
            int sum = 0;
            while (i > 0) {
                sum += bit[i];
                i -= lowbit(i);
            }
            return sum;
        }

        int lowbit(int n) {
            return n & (-n);
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.countSmaller(new int[] {5, 2, 6, 1}));
    }
}
