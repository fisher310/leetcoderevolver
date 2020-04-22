package p1178;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 猜字谜 <br>
 * puzzles 首字母必须出现，且单词中不能有其他非puzzles中的字符
 */
class Solution {
    public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {

        // puzzles 首字母必须出现，且单词中不能有其他非puzzles中的字符
        List<Integer> ans = new ArrayList<>();
        Set<Character> ps = new HashSet<>();
        for (String puzzle : puzzles) {
            ps.clear();
            for (char c : puzzle.toCharArray()) {
                ps.add(c);
            }
            int count = 0;
            outer:
            for (String word : words) {
                if (word.indexOf(puzzle.charAt(0)) >= 0) {
                    // 查看单词中的其他字符是否在puzzle中
                    for (char c : word.toCharArray()) {
                        if (!ps.contains(c)) {
                            continue outer;
                        }
                    }
                    count++;
                }
            }
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
        List<String> lines =
                Files.readAllLines(
                        Paths.get(
                                "D:\\spaces\\github.com\\leetcodesolver\\src\\main\\java\\p1178\\test.txt"));
        String[] words = lines.get(0).split(",");
        String[] puzzles = lines.get(1).split(",");

        System.out.println(words.length);
        System.out.println(puzzles.length);
        long start = System.currentTimeMillis();
        ans = s.findNumOfValidWords(words, puzzles);
        long duration = System.currentTimeMillis() - start;
        System.out.println(ans);
        System.out.println("duration: " + duration);
    }
}
