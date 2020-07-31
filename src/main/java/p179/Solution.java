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
                                    char[] ch1 = o1.toCharArray();
                                    char[] ch2 = o2.toCharArray();
                                    int i = 0;
                                    while (i < ch1.length && i < ch2.length) {
                                        if (ch1[i] < ch2[i]) {
                                            return 1;
                                        } else if (ch1[i] > ch2[i]) {
                                            return -1;
                                        } else {
                                            i++;
                                        }
                                    }
                                    int k = 0;
                                    while (i < ch1.length - 1) {
                                        if (ch1[i] == ch1[k]) {
                                            k++;
                                            continue;
                                        } else {
                                            i++;
                                        }
                                        return Character.compare(ch1[k], ch1[i]);
                                    }

                                    while (i < ch2.length - 1) {
                                        if (ch2[i] == ch2[k]) {
                                            k++;
                                            continue;
                                        } else {
                                            i++;
                                        }
                                        return Character.compare(ch2[k], ch2[i]);
                                    }
                                    return 0;
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
        System.out.println(s.largestNumber(new int[] {0, 0}));
        System.out.println(s.largestNumber(new int[] {128, 12}));
        System.out.println(s.largestNumber(new int[] {10, 2}));
        System.out.println(s.largestNumber(new int[] {3, 30, 34, 5, 9}));
    }
}
