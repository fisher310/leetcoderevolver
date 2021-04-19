package p216;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 找出所有相加之和为n 的k个数的组合。组合中只允许含有 1-9 的正整数，并且每种组合中不存在重复的数字。
 * <p>
 * 说明：
 * <p>
 * 所有数字都是正整数。
 * 解集不能包含重复的组合。
 * 示例 1:
 * <p>
 * 输入: k = 3, n = 7
 * 输出: [[1,2,4]]
 * 示例 2:
 * <p>
 * 输入: k = 3, n = 9
 * 输出: [[1,2,6], [1,3,5], [2,3,4]]
 *
 * @author lihailong
 * @since 2021/04/19 11:41:51
 */
class Solution {

    private List<List<Integer>> ans;

    public List<List<Integer>> combinationSum3(int k, int n) {
        this.ans = new ArrayList<>();
        help(k, n, 0, 1, new LinkedList<>());

        return ans;
    }

    private void help(int k, int n, int sum, int next, LinkedList<Integer> list) {
        if (list.size() == k) {
            if (n == sum) {
                ans.add(new ArrayList<>(list));
            }
            return;
        }

        for (int i = next; i < 10; i++) {
            list.addLast(i);
            help(k, n, sum + i, i + 1, list);
            list.removeLast();
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.combinationSum3(3, 7));
        System.out.println(s.combinationSum3(3, 9));
    }
}
