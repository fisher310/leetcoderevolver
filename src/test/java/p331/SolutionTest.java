package p331;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class SolutionTest {

    @Test
    public void isValidSerialization() {

        Solution s = new Solution();
        assertTrue(s.isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#"));
    }
}