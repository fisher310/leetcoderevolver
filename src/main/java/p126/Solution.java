package p126;

import java.util.*;

class Solution {

    int min = 1;

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {

        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) return Collections.emptyList();

        Map<String, List<String>> map = new HashMap<>();
        boolean found = bfs(beginWord, endWord, wordSet, map);
        if (!found) return Collections.emptyList();

        List<String> res = new ArrayList<>();
        List<List<String>> ans = new ArrayList<>();

        Set<String> visited = new HashSet<>();
        res.add(beginWord);
        visited.add(beginWord);
        dfs(beginWord, endWord, map, visited, res, ans);

        return ans;
    }

    private boolean bfs(
            String beginWord, String endWord, Set<String> wordSet, Map<String, List<String>> map) {
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        visited.add(endWord);

        Set<String> beginSet = new HashSet<>();
        beginSet.add(beginWord);
        Set<String> endSet = new HashSet<>();
        endSet.add(endWord);

        boolean forward = true;
        boolean found = false;
        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            min++;
            if (beginSet.size() > endSet.size()) {
                Set<String> tmp = beginSet;
                beginSet = endSet;
                endSet = tmp;

                forward = !forward;
            }

            Set<String> nextLevelVisited = new HashSet<>();

            for (String word : beginSet) {
                char[] ch = word.toCharArray();
                for (int i = 0; i < ch.length; i++) {
                    char old = ch[i];
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == old) continue;
                        ch[i] = c;
                        String nextWord = new String(ch);
                        if (wordSet.contains(nextWord)) {
                            if (endSet.contains(nextWord)) {
                                found = true;
                                addSuccessor(word, nextWord, forward, map);
                            }

                            if (!visited.contains(nextWord)) {
                                nextLevelVisited.add(nextWord);
                                addSuccessor(word, nextWord, forward, map);
                            }
                        }
                    }
                    ch[i] = old;
                }
            }

            beginSet = nextLevelVisited;
            visited.addAll(nextLevelVisited);

            if (found) break;
        }

        return found;
    }

    private void addSuccessor(
            String word, String nextWord, boolean forward, Map<String, List<String>> map) {
        if (!forward) {
            String tmp = word;
            word = nextWord;
            nextWord = tmp;
        }

        map.computeIfAbsent(word, s -> new ArrayList<>());
        map.get(word).add(nextWord);
    }

    private void dfs(
            String beginWord,
            String endWord,
            Map<String, List<String>> map,
            Set<String> visited,
            List<String> res,
            List<List<String>> ans) {
        if (res.size() > min) return;
        if (beginWord.equals(endWord)) {
            if (res.size() < min) {
                min = res.size();
                ans.clear();
            }
            ans.add(new ArrayList<>(res));
            return;
        }

        List<String> neighbors = map.get(beginWord);
        if (neighbors == null) return;
        for (String neighbor : neighbors) {
            if (!visited.contains(neighbor)) {
                visited.add(neighbor);
                res.add(neighbor);
                dfs(neighbor, endWord, map, visited, res, ans);
                res.remove(res.size() - 1);
                visited.remove(neighbor);
            }
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        List<List<String>> ans =
                s.findLadders(
                        "hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log", "cog"));
        for (List<String> res : ans) {
            System.out.println(res);
        }

        String beginWord = "cet", endWord = "ism";
        String[] wordList =
                new String[] {
                    "kid", "tag", "pup", "ail", "tun", "woo", "erg", "luz", "brr", "gay", "sip",
                    "kay", "per", "val", "mes", "ohs", "now", "boa", "cet", "pal", "bar", "die",
                    "war", "hay", "eco", "pub", "lob", "rue", "fry", "lit", "rex", "jan", "cot",
                    "bid", "ali", "pay", "col", "gum", "ger", "row", "won", "dan", "rum", "fad",
                    "tut", "sag", "yip", "sui", "ark", "has", "zip", "fez", "own", "ump", "dis",
                    "ads", "max", "jaw", "out", "btu", "ana", "gap", "cry", "led", "abe", "box",
                    "ore", "pig", "fie", "toy", "fat", "cal", "lie", "noh", "sew", "ono", "tam",
                    "flu", "mgm", "ply", "awe", "pry", "tit", "tie", "yet", "too", "tax", "jim",
                    "san", "pan", "map", "ski", "ova", "wed", "non", "wac", "nut", "why", "bye",
                    "lye", "oct", "old", "fin", "feb", "chi", "sap", "owl", "log", "tod", "dot",
                    "bow", "fob", "for", "joe", "ivy", "fan", "age", "fax", "hip", "jib", "mel",
                    "hus", "sob", "ifs", "tab", "ara", "dab", "jag", "jar", "arm", "lot", "tom",
                    "sax", "tex", "yum", "pei", "wen", "wry", "ire", "irk", "far", "mew", "wit",
                    "doe", "gas", "rte", "ian", "pot", "ask", "wag", "hag", "amy", "nag", "ron",
                    "soy", "gin", "don", "tug", "fay", "vic", "boo", "nam", "ave", "buy", "sop",
                    "but", "orb", "fen", "paw", "his", "sub", "bob", "yea", "oft", "inn", "rod",
                    "yam", "pew", "web", "hod", "hun", "gyp", "wei", "wis", "rob", "gad", "pie",
                    "mon", "dog", "bib", "rub", "ere", "dig", "era", "cat", "fox", "bee", "mod",
                    "day", "apr", "vie", "nev", "jam", "pam", "new", "aye", "ani", "and", "ibm",
                    "yap", "can", "pyx", "tar", "kin", "fog", "hum", "pip", "cup", "dye", "lyx",
                    "jog", "nun", "par", "wan", "fey", "bus", "oak", "bad", "ats", "set", "qom",
                    "vat", "eat", "pus", "rev", "axe", "ion", "six", "ila", "lao", "mom", "mas",
                    "pro", "few", "opt", "poe", "art", "ash", "oar", "cap", "lop", "may", "shy",
                    "rid", "bat", "sum", "rim", "fee", "bmw", "sky", "maj", "hue", "thy", "ava",
                    "rap", "den", "fla", "auk", "cox", "ibo", "hey", "saw", "vim", "sec", "ltd",
                    "you", "its", "tat", "dew", "eva", "tog", "ram", "let", "see", "zit", "maw",
                    "nix", "ate", "gig", "rep", "owe", "ind", "hog", "eve", "sam", "zoo", "any",
                    "dow", "cod", "bed", "vet", "ham", "sis", "hex", "via", "fir", "nod", "mao",
                    "aug", "mum", "hoe", "bah", "hal", "keg", "hew", "zed", "tow", "gog", "ass",
                    "dem", "who", "bet", "gos", "son", "ear", "spy", "kit", "boy", "due", "sen",
                    "oaf", "mix", "hep", "fur", "ada", "bin", "nil", "mia", "ewe", "hit", "fix",
                    "sad", "rib", "eye", "hop", "haw", "wax", "mid", "tad", "ken", "wad", "rye",
                    "pap", "bog", "gut", "ito", "woe", "our", "ado", "sin", "mad", "ray", "hon",
                    "roy", "dip", "hen", "iva", "lug", "asp", "hui", "yak", "bay", "poi", "yep",
                    "bun", "try", "lad", "elm", "nat", "wyo", "gym", "dug", "toe", "dee", "wig",
                    "sly", "rip", "geo", "cog", "pas", "zen", "odd", "nan", "lay", "pod", "fit",
                    "hem", "joy", "bum", "rio", "yon", "dec", "leg", "put", "sue", "dim", "pet",
                    "yaw", "nub", "bit", "bur", "sid", "sun", "oil", "red", "doc", "moe", "caw",
                    "eel", "dix", "cub", "end", "gem", "off", "yew", "hug", "pop", "tub", "sgt",
                    "lid", "pun", "ton", "sol", "din", "yup", "jab", "pea", "bug", "gag", "mil",
                    "jig", "hub", "low", "did", "tin", "get", "gte", "sox", "lei", "mig", "fig",
                    "lon", "use", "ban", "flo", "nov", "jut", "bag", "mir", "sty", "lap", "two",
                    "ins", "con", "ant", "net", "tux", "ode", "stu", "mug", "cad", "nap", "gun",
                    "fop", "tot", "sow", "sal", "sic", "ted", "wot", "del", "imp", "cob", "way",
                    "ann", "tan", "mci", "job", "wet", "ism", "err", "him", "all", "pad", "hah",
                    "hie", "aim", "ike", "jed", "ego", "mac", "baa", "min", "com", "ill", "was",
                    "cab", "ago", "ina", "big", "ilk", "gal", "tap", "duh", "ola", "ran", "lab",
                    "top", "gob", "hot", "ora", "tia", "kip", "han", "met", "hut", "she", "sac",
                    "fed", "goo", "tee", "ell", "not", "act", "gil", "rut", "ala", "ape", "rig",
                    "cid", "god", "duo", "lin", "aid", "gel", "awl", "lag", "elf", "liz", "ref",
                    "aha", "fib", "oho", "tho", "her", "nor", "ace", "adz", "fun", "ned", "coo",
                    "win", "tao", "coy", "van", "man", "pit", "guy", "foe", "hid", "mai", "sup",
                    "jay", "hob", "mow", "jot", "are", "pol", "arc", "lax", "aft", "alb", "len",
                    "air", "pug", "pox", "vow", "got", "meg", "zoe", "amp", "ale", "bud", "gee",
                    "pin", "dun", "pat", "ten", "mob"
                };
        List<List<String>> ladders = s.findLadders(beginWord, endWord, Arrays.asList(wordList));
        for (List<String> ladder : ladders) {
            System.out.println(ladder);
        }
    }
}
