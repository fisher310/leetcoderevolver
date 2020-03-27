package p28;

import java.util.HashMap;
import java.util.Map;

/**
 * 实现 strStr() 函数。
 *
 * <p>给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 *
 * <p>示例 1:
 *
 * <p>输入: haystack = "hello", needle = "ll" 输出: 2 示例 2:
 *
 * <p>输入: haystack = "aaaaa", needle = "bba" 输出: -1
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/implement-strstr
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。 当needle 为空字符串时，返回0
 */
class Solution {
    public int strStr(String haystack, String needle) {
        if (null == haystack || needle == null) return -1;
        if ("".equals(needle)) return 0;
        int LH = haystack.length();
        int LN = needle.length();

        char[] ha = haystack.toCharArray();
        char[] ne = needle.toCharArray();

        Map<Character, Integer> map = new HashMap<>(LN);
        for (int i = 0; i < ne.length; i++) {
            map.put(ne[i], LN - i);
        }

        int i = 0;
        while (i <= LH - LN) {
            if (equals(ha, ne, i, LN)) return i;
            if (i + LN >= LH) return -1;
            Integer pos = map.get(ha[i + LN]);
            if (null != pos) {
                i += pos;
            } else {
                i += LN + 1;
            }
        }

        return -1;
    }

    boolean equals(char[] ha, char[] ne, int i, int LN) {
        int j = i;
        int k = 0;
        while (k < LN && ha[j] == ne[k]) {
            j++;
            k++;
        }
        return k == LN;
    }
}

//    solution one
//    if (null == haystack || needle == null) {
//        return -1;
//    }
//        if ("".equals(needle)) {
//        return 0;
//    }
//
//    int ans = -1;
//    int LN = needle.length();
//    int LH = haystack.length();
//    char[] ha = haystack.toCharArray();
//    char[] ne = needle.toCharArray();
//        for (int i = 0, n = LH - LN; i <= n; i++) {
//        if (ha[i] == ne[0]) {
//            int j = i + 1, k = 1;
//            ans = i;
//            while (j < LH && k < LN) {
//                if (ha[j] != ne[k]) {
//                    break;
//                }
//                j++;
//                k++;
//            }
//            if (k == LN) {
//                break;
//            } else {
//                ans = -1;
//            }
//        }
//    }
//        return ans;
// }
