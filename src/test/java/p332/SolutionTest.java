package p332;

import org.junit.Test;
import util.ListUtil;

import java.util.ArrayList;
import java.util.List;

public class SolutionTest {

    @Test
    public void findItinerary() {

        Solution s = new Solution();
        List<String> ans = s.findItinerary(new ArrayList<>() {{
            add(List.of("EZE", "TIA"));
            add(List.of("EZE", "AXA"));
            add(List.of("AUA", "EZE"));
            add(List.of("EZE", "JFK"));
            add(List.of("JFK", "ANU"));
            add(List.of("JFK", "ANU"));
            add(List.of("AXA", "TIA"));
            add(List.of("JFK", "AUA"));
            add(List.of("TIA", "JFK"));
            add(List.of("ANU", "EZE"));
            add(List.of("ANU", "EZE"));
            add(List.of("TIA", "AUA"));
        }});
        System.out.println(ans);
        List<String> expect = List.of("JFK", "ANU", "EZE", "AXA", "TIA", "AUA", "EZE", "JFK", "ANU", "EZE", "TIA", "JFK", "AUA");
        System.out.println(expect);
        ListUtil.assertEquals(expect, ans);
    }


}