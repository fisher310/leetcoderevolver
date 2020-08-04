package p179;

import org.junit.Assert;

import java.util.Arrays;
import java.util.stream.Collectors;

class Solution {
    public String largestNumber(int[] nums) {
        String res =
                Arrays.stream(nums)
                        .mapToObj(String::valueOf)
                        .sorted(
                                ((o1, o2) -> {
                                    String a = o1 + o2;
                                    String b = o2 + o1;
                                    return b.compareTo(a);
                                }))
                        .collect(Collectors.joining());

        char[] ch = res.toCharArray();
        int i = 0;
        while (i < ch.length - 1 && ch[i] == '0') {
            i++;
        }
        return res.substring(i);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        Assert.assertEquals("12121", s.largestNumber(new int[] {121, 12}));
        Assert.assertEquals("9534330", s.largestNumber(new int[] {3, 30, 34, 5, 9}));
        Assert.assertEquals(
                "9609938824824769735703560743981399",
                s.largestNumber(new int[] {824, 938, 1399, 5607, 6973, 5703, 9609, 4398, 8247}));
        Assert.assertEquals("0", s.largestNumber(new int[] {0, 0}));
        Assert.assertEquals("12812", s.largestNumber(new int[] {128, 12}));
        System.out.println(s.largestNumber(new int[] {10, 2}));
        System.out.println(s.largestNumber(new int[] {3, 30, 34, 5, 9}));
    }
}
