package p401;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 二进制手表
 *
 * <p>8, 4, 2, 1 代表：0-11 <br>
 * 32, 16, 8, 4, 2, 1 代表 0-59 <br>
 * 输出的顺序没有要求。 小时不会以零开头，比如 “01:00” 是不允许的，应为 “1:00”。 分钟必须由两位数组成，可能会以零开头，比如 “10:2” 是无效的，应为 “10:02”。
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/binary-watch
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {
    //    Set<Integer> clocks = Stream.of(1, 2, 4, 8).collect(Collectors.toSet());;
    //
    //    Set<Integer> minutes = Stream.of(1, 2, 4, 8, 16, 32).collect(Collectors.toSet());

    int[] clocks = new int[] {1, 2, 4, 8};
    int[] minutes = new int[] {1, 2, 4, 8, 16, 32};
    private Set<String> ans;
    boolean[] cVisited = new boolean[4];
    boolean[] mVisited = new boolean[6];

    public List<String> readBinaryWatch(int num) {

        ans = new HashSet<>();
        List<Integer> cList = new ArrayList<>();
        List<Integer> mList = new ArrayList<>();
        for (int i = 0; i <= Math.min(num, 4); i++) {
            int j = num - i;
            if (j > 6) {
                continue;
            }
            helper(i, j, 0, 0, cList, mList);
        }

        return new ArrayList<>(ans);
    }

    void helper(int i, int j, int cStart, int mStart, List<Integer> cList, List<Integer> mList) {
        if (i == 0 && j == 0) {

            int sumC = cList.size() == 0 ? 0 : cList.stream().mapToInt(Integer::intValue).sum();
            int sumM = mList.size() == 0 ? 0 : mList.stream().mapToInt(Integer::intValue).sum();
            if (sumC < 12 && sumM < 60) {
                //            System.out.println(Arrays.toString(cVisited) + " sumC: " + sumC);
                //            System.out.println(Arrays.toString(mVisited) + " sumM: " + sumM);
                ans.add(String.format("%d:%02d", sumC, sumM));
            }
            return;
        }

        if (i > 0) {
            for (int ic = cStart; ic < clocks.length; ic++) {
                if (!cVisited[ic]) {
                    cList.add(clocks[ic]);
                    cVisited[ic] = true;
                    helper(i - 1, j, ic + 1, mStart, cList, mList);
                    cVisited[ic] = false;
                    cList.remove(cList.size() - 1);
                }
            }
        }

        if (j > 0) {
            for (int jm = mStart; jm < minutes.length; jm++) {
                if (!mVisited[jm]) {
                    mList.add(minutes[jm]);
                    mVisited[jm] = true;
                    helper(i, j - 1, cStart, jm + 1, cList, mList);
                    mVisited[jm] = false;
                    mList.remove(mList.size() - 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        List<String> ans = s.readBinaryWatch(2);
        System.out.println(ans);
        Map<String, Integer> test =
                ans.stream()
                        .collect(
                                Collectors.groupingBy(
                                        a -> a, Collectors.reducing(0, s2 -> 1, Integer::sum)));
        test.forEach((key, value) -> System.out.println(key + ":" + value));
        System.out.println(ans.stream().distinct().sorted().collect(Collectors.toList()));
        List<String> expected =
                Stream.of(
                                "0:03", "0:05", "0:06", "0:09", "0:10", "0:12", "0:17", "0:18",
                                "0:20", "0:24", "0:33", "0:34", "0:36", "0:40", "0:48", "1:01",
                                "1:02", "1:04", "1:08", "1:16", "1:32", "2:01", "2:02", "2:04",
                                "2:08", "2:16", "2:32", "3:00", "4:01", "4:02", "4:04", "4:08",
                                "4:16", "4:32", "5:00", "6:00", "8:01", "8:02", "8:04", "8:08",
                                "8:16", "8:32", "9:00", "10:00")
                        .sorted()
                        .collect(Collectors.toList());
        System.out.println(expected);
    }
}
