package p575;

import java.util.HashSet;
import java.util.Set;

class Solution {

    public int distributeCandies(int[] candies) {

        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < candies.length && set.size() < candies.length / 2; i++) {
            set.add(candies[i]);
        }

        return set.size();
    }
}
