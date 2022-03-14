package p68;

import java.util.*;

class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {

        List<String> res = new ArrayList<>();
        List<String> line = new ArrayList<>();
        int total = 0;
        for (int i = 0; i < words.length;) {
            line.clear();
            total = 0;
            while (i < words.length && total + line.size() - 1 < maxWidth) {
                if ((total + line.size() + words[i].length()) > maxWidth) {
                    break;
                }
                line.add(words[i]);
                total += words[i].length();
                i++;
            }

            String row = "";
            if (line.size() == 1) {
                row = line.get(0);
                while (row.length() < maxWidth) {
                    row = row + " ";
                }
                res.add(row);
                continue;
            }

            if (i < words.length) {

                int spaces = maxWidth - total;
                int size = line.size() - 1;
                while (size > 0) {
                    int last = spaces / size;
                    row = line.get(size) + row;
                    for (int k = 0; k < last; k++) {
                        row = " " + row;
                    }
                    size--;
                    spaces -= last;
                }
                row = line.get(0) + row;
                res.add(row);
            } else {
                // last row
                for (int k = 0; k < line.size(); k++) {
                    row += line.get(k) + " ";
                }
                if (row.length() > maxWidth) {
                    row = row.substring(0, row.length() - 1);
                } else {
                    for (int k = row.length(); k < maxWidth; k++) {
                        row += " ";
                    }
                }
                res.add(row);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        List<String> res;
        res = s.fullJustify(new String[] { "What", "must", "be", "acknowledgment", "shall", "be" }, 16);
        print(res);
        res = s.fullJustify(new String[] { "This", "is", "an", "example", "of", "text", "justification." },
                16);
        print(res);
        res = s.fullJustify(new String[] { "Science", "is", "what", "we", "understand", "well", "enough", "to",
                "explain", "to", "a", "computer.", "Art", "is", "everything", "else", "we", "do" }, 20);
        print(res);
    }

    private static void print(List<String> res) {
        for (String line : res) {
            System.out.println(line);
        }
    }

}
