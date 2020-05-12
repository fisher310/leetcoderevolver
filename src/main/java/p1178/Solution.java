package p1178;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 猜字谜 <br>
 * puzzles 首字母必须出现，且单词中不能有其他非puzzles中的字符
 */
class Solution {

    public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {

        List<Integer> ans = new ArrayList<>();
        Map<Integer, Integer> bit2cnt = new HashMap<>();
        for (String word : words) {
            int k = 0;
            for (int j = 0; j < word.length(); j++) {
                k |= (1 << (word.charAt(j) - 'a'));
            }
            bit2cnt.put(k, bit2cnt.getOrDefault(k, 0) + 1);
        }

        for (String puzzle : puzzles) {
            int k = 0;
            int count = 0;
            for (int j = 0; j < puzzle.length(); j++) {
                k |= 1 << (puzzle.charAt(j) - 'a');
            }
            for (int j = k; j != 0; j = ((j - 1) & k)) {
                System.out.println(Integer.toBinaryString(j));
                if (((1 << (puzzle.charAt(0) - 'a')) & j) != 0) {
                    count += bit2cnt.getOrDefault(j, 0);
                }
            }
            System.out.println("=====================================");
            ans.add(count);
        }

        return ans;
    }

    public static void main(String[] args) throws URISyntaxException, IOException {
        Solution s = new Solution();
        List<Integer> ans =
                s.findNumOfValidWords(
                        new String[] {"aaaa", "asas", "able", "ability", "actt", "actor", "access"},
                        new String[] {
                            "aboveyz", "abrodyz", "abslute", "absoryz", "actresz", "gaswxyz"
                        });
        System.out.println(ans);
        //        List<String> lines =
        //                Files.readAllLines(
        //                        Paths.get(
        //
        // "D:\\spaces\\github.com\\leetcodesolver\\src\\main\\java\\p1178\\test.txt"));
        //        String[] words = lines.get(0).split(",");
        //        String[] puzzles = lines.get(1).split(",");
        //
        //        System.out.println(words.length);
        //        System.out.println(puzzles.length);
        //        long start = System.currentTimeMillis();
        //        ans = s.findNumOfValidWords(words, puzzles);
        //        long duration = System.currentTimeMillis() - start;
        //        System.out.println(ans);
        //        System.out.println("duration: " + duration);
    }
}
