package p1494;

import org.junit.Assert;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {

    public int minNumberOfSemesters(int n, int[][] dependencies, int k) {

        // 入度, 入度是0 则可以上课啦
        int[] in = new int[n + 1];
        //
        Subject[] subjects = new Subject[n + 1];
        for (int i = 1; i <= n; i++) {
            subjects[i] = new Subject(i);
        }

        for (int[] dep : dependencies) {
            in[dep[1]] += 1;
            subjects[dep[0]].addNext(dep[1]);
        }

        for (int i = 1; i <= n; i++) {
            dfs(subjects[i]);
        }

        // 课程排列完毕，准备上课
        int epoch = 0;
        Set<Integer> learned = new HashSet<>();
        while (learned.size() < n) {
            // 一个学期
            Set<Integer> select = new HashSet<>();

            for (int i = 1; i <= n; i++) {
                if (subjects[i].next.size() > 0 && in[i] == 0 &&!learned.contains(i)) {
                    if (select.size() < k) {
                        select.add(i);
                    } else {
                        break;
                    }
                }
            }
            for (int i = 1; i <= n; i++) {
                if (in[i] == 0 && !learned.contains(i) && !select.contains(i)) {
                    // 上课
                    if (select.size() < k) {
                        select.add(i);
                    } else {
                        break;
                    }
                }
            }

            learned.addAll(select);
            for (int id : select) {
                for (int next : subjects[id].next) {
                    in[next] -= 1;
                }
            }
            System.out.println(select);
            epoch++;
        }

        return epoch;
    }
    private void dfs(Subject subject) {

    }

    static class Subject {
        int id;
        // 后继课程
        int depth;
        List<Integer> next;

        Subject(int id) {
            this.id = id;
            depth = 0;
            this.next = new ArrayList<>();
        }

        void addNext(int id) {
            next.add(id);
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        Assert.assertEquals(
                6,
                s.minNumberOfSemesters(
                        12,
                        new int[][] {
                            {1, 2}, {1, 3}, {7, 5}, {7, 6}, {4, 8}, {8, 9}, {9, 10}, {10, 11},
                            {11, 12}
                        },
                        2));
        System.out.println(
                s.minNumberOfSemesters(5, new int[][] {{2, 1}, {3, 1}, {4, 1}, {1, 5}}, 2));

        Assert.assertEquals(6, s.minNumberOfSemesters(11, new int[][] {}, 2));
    }
}
