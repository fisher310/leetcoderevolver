package p131;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author lihailong
 * @since 2021/04/09 11:15:38
 */
public class SolutionTest {

    @Test
    public void partition() {
        Solution s = new Solution();


        print(s.partition("abbab"));
        print(s.partition("aab"));
        print(s.partition("a"));

    }

    private void print(List<List<String>> res) {
        for (List<String> rr : res) {
            System.out.print(rr + ", ");
        }

        System.out.println();
    }
}