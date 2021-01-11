package test;

import java.util.*;

/**
 * @author lihailong
 * @since 2020/12/16 0016
 */
class Test3 {

    private List<List<Character>> ans;

    public List<List<Character>> generate(char[] ch) {

        ans = new ArrayList<>();
        helper(ch, new LinkedList<>(), new HashSet<>());

        return ans;
    }

    private void helper(char[] ch, LinkedList<Character> list, Set<Character> visited) {
        if (list.size() == ch.length) {
            ans.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < ch.length; i++) {
            if (!visited.contains(ch[i])) {
                list.addLast(ch[i]);
                visited.add(ch[i]);
                helper(ch,  list, visited);
                list.removeLast();
                visited.remove(ch[i]);
            }
        }
    }

    public static void main(String[] args) {
        Test3 t = new Test3();
        List<List<Character>> ans = t.generate(new char[] {'A', 'B', 'C'});
        for (List<Character> list : ans) {
            System.out.println(list);
        }
    }
}
