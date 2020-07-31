package p118;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

class Solution {

    public List<List<Integer>> generate(int numRows) {
        if (numRows == 0) return Collections.emptyList();
        List<List<Integer>> ans = new LinkedList<>();
        ans.add(List.of(1));
        if (numRows == 1) return ans;
        ans.add(List.of(1, 1));
        if (numRows == 2) return ans;
        for (int i = 3; i <= numRows; i++) {
            List<Integer> list = new ArrayList<>(i);
            List<Integer> previous = ans.get(ans.size() - 1);
            list.add(1);
            for (int j = 1; j < i - 1; j++) {
                list.add(previous.get(j - 1) + previous.get(j));
            }
            list.add(1);
            ans.add(list);
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        List<List<Integer>> generate = s.generate(5);
        for (List<Integer> row : generate) {
            System.out.println(row);
        }
    }
}
