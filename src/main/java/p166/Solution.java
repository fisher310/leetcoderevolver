package p166;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author lihailong
 * @since 2021/05/08 13:15:21
 */
class Solution {

    public String fractionToDecimal(int numerator, int denominator) {

        int i = numerator / denominator;

        int n = numerator % denominator;

        StringBuilder sb = new StringBuilder();
        sb.append(i).append('.');
        Map<Integer, Integer> map = new HashMap<>();

        while (n != 0) {
            i = n * 10 / denominator;
        }
        return null;
    }
}
