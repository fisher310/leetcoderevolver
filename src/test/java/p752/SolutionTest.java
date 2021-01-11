package p752;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author lihailong
 * @since 2020/12/14 0014
 */
public class SolutionTest {

    @Test
    public void openLock() {

        Solution s = new Solution();
        assertEquals(6, s.openLock(new String[] {"0201", "0101", "0102", "1212", "2002"}, "0202"));
        assertEquals(
                -1,
                s.openLock(
                        new String[] {
                            "8887", "8889", "8878", "8898", "8788", "8988", "7888", "9888"
                        },
                        "8888"));
        assertEquals(1, s.openLock(new String[] {"8888"}, "0009"));
    }
}
