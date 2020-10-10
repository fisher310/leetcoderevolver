package p1593;

import org.junit.Assert;

import java.util.HashSet;
import java.util.Set;

/** ababccc [a, b, ab, c, cc] */
class Solution {

    int max = 0;

    public int maxUniqueSplit(String s) {
        dfs(s, 0, 0, new HashSet<>());
        return max;
    }

    private void dfs(String s, int curr, int num, Set<String> visited) {
        if (curr >= s.length()) {
            max = Math.max(max, num);
            return;
        }

        for (int i = curr + 1; i <= s.length(); i++) {
            String sub = s.substring(curr, i);
            if (!visited.contains(sub)) {
                visited.add(sub);
                dfs(s, i, num + 1, visited);
                visited.remove(sub);
            }
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        Assert.assertEquals(1, s.maxUniqueSplit("aa"));
        Assert.assertEquals(2, s.maxUniqueSplit("aba"));
        Assert.assertEquals(5, s.maxUniqueSplit("ababccc"));
    }
}
