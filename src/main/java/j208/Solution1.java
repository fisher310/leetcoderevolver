package j208;

import org.junit.Assert;

import java.util.LinkedList;

class Solution1 {

    public int minOperations(String[] logs) {
        LinkedList<String> stack = new LinkedList<>();

        for (int i = 0; i < logs.length; i++) {
            String log = logs[i];
            if (log.startsWith("../")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else if (log.startsWith("./")) {
                continue;
            } else {
                stack.push(log);
            }
        }

        return stack.size();
    }

    public static void main(String[] args) {
        Solution1 s = new Solution1();
        Assert.assertEquals(
                3, s.minOperations(new String[] {"d1/", "d2/", "./", "d3/", "../", "d31/"}));
        Assert.assertEquals(
                2, s.minOperations(new String[] {"d1/","d2/","../","d21/","./"}));
        Assert.assertEquals(
                0, s.minOperations(new String[] {"d1/","../","../","../"}));
    }
}
