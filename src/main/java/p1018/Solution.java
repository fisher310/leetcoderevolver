package p1018;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lihailong
 * @since 2021/1/14 0014
 */
class Solution {

    public List<Boolean> prefixesDivBy5(int[] A) {

        List<Boolean> ans = new ArrayList<>(A.length);

        int x = 0;
        for (int i = 0; i < A.length; i++) {
            x = ((x << 1) | A[i]) % 5;
            ans.add(x == 0);
        }

        return ans;
    }
}
