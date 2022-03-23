package p1005;

import java.util.*;

public class Solution {

    public int largestSumAfterKNegations(int[] nums, int k) {

        int zero = 0;
        PriorityQueue<Integer> leZero = new PriorityQueue<>();
        PriorityQueue<Integer> gtZero = new PriorityQueue<>();

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zero++;
            } else if (nums[i] < 0) {
                leZero.offer(nums[i]);
            } else {
                gtZero.offer(nums[i]);
            }
        }

        while (k > 0) {
            if (leZero.size() > 0) {
                gtZero.offer(-leZero.poll());
            } else if (zero == 0) {
                leZero.offer(-gtZero.poll());
            }
        }

        int ans = 0;
        for (int n : leZero) {
            ans += n;
        }
        for (int n : gtZero) {
            ans += n;
        }

        return ans;
    }
}