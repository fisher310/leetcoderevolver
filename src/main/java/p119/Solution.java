package p119;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> getRow(int rowIndex) {
        if (rowIndex == 0) {
            return List.of(1);
        }
        if (rowIndex == 1) {
            return List.of(1, 1);
        }
        List<Integer> ans = new ArrayList<>(rowIndex);
        ans.add(1);
        List<Integer> row = getRow(rowIndex - 1);
        for (int i = 1; i < rowIndex; i++) {
            ans.add(row.get(i - 1) + row.get(i));
        }
        ans.add(1);
        return ans;
    }
}
