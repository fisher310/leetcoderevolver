package p451;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void frequencySort() {
        System.out.println(Character.MIN_VALUE);
        System.out.println((int) Character.MAX_VALUE);
        Solution s = new Solution();
        assertEquals("eert", s.frequencySort("tree"));
        System.out.println(s.frequencySort("cccaaa"));
        System.out.println(s.frequencySort("Aabb"));
    }
}
