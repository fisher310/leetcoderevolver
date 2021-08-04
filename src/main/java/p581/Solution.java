package p581;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.LinkedList;

import org.junit.*;

import jdk.nashorn.api.tree.WhileLoopTree;

/**
 * 
 * 
 * 请你找出符合题意的 最短 子数组，并输出它的长度。
 */
class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int[] sortedNums = new int[nums.length];
        System.arraycopy(nums, 0, sortedNums, 0, nums.length);
        Arrays.sort(sortedNums);
        int left = 0;
        int right = nums.length -1;
        while (left < nums.length && nums[left] == sortedNums[left]) {
            left++;
        } 
        while (right >=0 && nums[right] == sortedNums[right]) {
            right--;
        }
        return right > left ? right - left + 1 : 0;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        assertEquals("case 9: ", 3, s.findUnsortedSubarray(new int[] { 1, 2, 4, 5, 3 }));
        assertEquals("case 0: ", 3, s.findUnsortedSubarray(new int[] { 2, 3, 3, 2, 4 }));
        assertEquals("case 8: ", 0, s.findUnsortedSubarray(new int[] { 1, 2, 3, 3, 3 }));
        assertEquals("case 7: ", 3, s.findUnsortedSubarray(new int[] { 1, 2, 5, 3, 4 }));
        assertEquals("case 1: ", 5, s.findUnsortedSubarray(new int[] { 5, 4, 3, 2, 1 }));
        assertEquals("case 2: ", 4, s.findUnsortedSubarray(new int[] { 1, 3, 2, 2, 2 }));
        assertEquals("case 3: ", 0, s.findUnsortedSubarray(new int[] { 0 }));
        assertEquals("case 4: ", 0, s.findUnsortedSubarray(new int[] { 1, 2, 3, 4 }));
        assertEquals("case 5: ", 5, s.findUnsortedSubarray(new int[] { 2, 6, 4, 8, 10, 9, 15 }));
        assertEquals("case 6: ", 2, s.findUnsortedSubarray(new int[] { 2, 6, 4, 8, 9, 10, 15 }));
    }
}
