package p496;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

class Solution {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        // num2 中元素右边第一个比他大的， 设计一个栈，从左到右，把没有找到比他大的元素放进去
        LinkedList<Integer> stack = new LinkedList<>();

        Map<Integer, Integer> map= new HashMap<>();

        for (int i = 0; i < nums2.length; i++) {
            while (!stack.isEmpty() && stack.peek() < nums2[i]) {
                map.put(stack.peek(), nums2[i]);
                stack.pop();
            }
            stack.push(nums2[i]);
        }
        int[] ans = new int[nums1.length];
        for (int i = 0; i < nums1.length;i++) {
            ans[i] = map.getOrDefault(nums1[i], -1);
        }

        return ans;
    }

}
