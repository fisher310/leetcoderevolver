package p1832;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author lihailong
 * @since 2021/04/20 14:04:50
 */
class Solution {

    public boolean checkIfPangram(String sentence) {

        Set<Character> set =
                new HashSet<>(
                        List.of(
                                'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
                                'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'));

        for (int i = 0; i < sentence.length(); i++) {
            char c = sentence.charAt(i);
            set.remove(c);
            if (set.isEmpty()) {
                return true;
            }
        }
        return set.isEmpty();
    }

}
