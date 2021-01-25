package p241;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lihailong
 * @since 2021/1/13 0013
 */
class Solution {

    public List<Integer> diffWaysToCompute(String input) {

        List<Integer> ans = new ArrayList<>();
        boolean isDigit = true;
        for (int i = 0; i < input.length(); i++) {

            if (!Character.isDigit(input.charAt(i))) {
                isDigit = false;
                // + - *
                char operator = input.charAt(i);
                List<Integer> left = diffWaysToCompute(input.substring(0, i));
                List<Integer> right = diffWaysToCompute(input.substring(i + 1));

                for (int l : left) {
                    for (int r : right) {
                        switch (operator) {
                            case '+':
                                ans.add(l + r);
                                break;
                            case '-':
                                ans.add(l - r);
                                break;
                            case '*':
                                ans.add(l * r);
                                break;
                        }
                    }
                }
            }
        }

        if (isDigit) ans.add(Integer.parseInt(input));

        return ans;
    }
}
