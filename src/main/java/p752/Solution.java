package p752;

import java.util.*;

/**
 * @author lihailong
 * @since 2020/12/14 0014
 */
class Solution {

    public int openLock(String[] deadends, String target) {
        Set<String> deadSet = new HashSet<>(Arrays.asList(deadends));
        if (deadSet.contains("0000")) {
            return -1;
        }

        Queue<String> queue = new LinkedList<>();
        // 0000 -> target
        queue.offer("0000");

        int step = 0;

        Set<String> visited = new HashSet<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            step++;
            for (int i = 0; i < size; i++) {
                String curr = queue.poll();
                char[] chars = curr.toCharArray();
                for (int j = 0; j < 4; j++) {
                    char old = chars[j];

                    for (int k = 0; k < 2; k++) {
                        changeOne(chars, j, k);
                        String newStr = new String(chars);

                        if (target.equals(newStr)) {
                            return step;
                        }
                        if (!deadSet.contains(newStr)) {
                            if (!visited.contains(newStr)) {
                                visited.add(newStr);
                                queue.offer(newStr);
                            }
                        }
                        chars[j] = old;
                    }
                }
            }
        }

        return -1;
    }

    private void changeOne(char[] chars, int i, int k) {
        if (k == 0) {
            // forward
            if (chars[i] == '9') {
                chars[i] = '0';
            } else {
                chars[i] = (char) (chars[i] + 1);
            }
        } else if (k == 1) {
            if (chars[i] == '0') {
                chars[i] = '9';
            } else {
                chars[i] = (char) (chars[i] - 1);
            }
        }
    }
}
