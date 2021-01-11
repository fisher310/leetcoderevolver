package p649;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author lihailong
 * @since 2020/12/11 0011
 */
public class SolutionTest {

    @Test
    public void predictPartyVictory() {
        Solution s = new Solution();
        assertEquals("Radiant", s.predictPartyVictory("RD"));
        assertEquals("Dire", s.predictPartyVictory("RDD"));
    }
}