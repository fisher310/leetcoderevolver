package p401;

import java.util.ArrayList;
import java.util.List;

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
    private List<String> ans;
    int[] nums = {1, 2, 4, 8, 1, 2, 4, 8, 16, 32};
    boolean[] visited;

    public List<String> readBinaryWatch(int num) {

        ans = new ArrayList<>();
        visited = new boolean[10];
        dfs(nums, num, 0, 0, 0);
        return new ArrayList<>(ans);
    }

    void dfs(int[] nums, int step, int start, int hour, int minute) {
        if (step == 0) {
            if (hour < 12 && minute < 60) {
//                ans.add(String.format("%d:%02d", hour, minute));
                StringBuilder sb=new StringBuilder();
                sb.append(hour);
                sb.append(":");
                if(minute<10){
                    sb.append(0);
                }
                sb.append(minute);
                ans.add(sb.toString());
            }
            return;
        }

        for (int i = start; i < nums.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                if (i < 4) {
                    hour += nums[i];
                } else {
                    minute += nums[i];
                }

                dfs(nums, step - 1, i + 1, hour, minute);
                visited[i] = false;
                if (i < 4) {
                    hour -= nums[i];
                } else {
                    minute -= nums[i];
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        long start = System.currentTimeMillis();
        List<String> ans = s.readBinaryWatch(5);
        long duration = System.currentTimeMillis() - start;
        System.out.println(ans);
        System.out.println("duration: " + duration);
//        Map<String, Integer> test =
//                ans.stream()
//                        .collect(
//                                Collectors.groupingBy(
//                                        a -> a, Collectors.reducing(0, s2 -> 1, Integer::sum)));
//        test.forEach((key, value) -> System.out.println(key + ":" + value));
//        System.out.println(ans.stream().distinct().sorted().collect(Collectors.toList()));
//        List<String> expected =
//                Stream.of(
//                                "0:03", "0:05", "0:06", "0:09", "0:10", "0:12", "0:17", "0:18",
//                                "0:20", "0:24", "0:33", "0:34", "0:36", "0:40", "0:48", "1:01",
//                                "1:02", "1:04", "1:08", "1:16", "1:32", "2:01", "2:02", "2:04",
//                                "2:08", "2:16", "2:32", "3:00", "4:01", "4:02", "4:04", "4:08",
//                                "4:16", "4:32", "5:00", "6:00", "8:01", "8:02", "8:04", "8:08",
//                                "8:16", "8:32", "9:00", "10:00")
//                        .sorted()
//                        .collect(Collectors.toList());
//        System.out.println(expected);
    }
}
