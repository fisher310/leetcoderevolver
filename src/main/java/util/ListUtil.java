package util;

import java.util.List;

public class ListUtil {

    private ListUtil() {
    }

    public static void print2(List<List<Integer>> list) {
        for (List<Integer> l : list) {
            System.out.println(l);
        }
        System.out.println("-------------------------------");
    }

    public static void print1(List<Integer> list) {
        System.out.println(list);
        System.out.println("-------------------------------");
    }

    public static <T> void assertEquals(List<T> t1, List<T> t2) {
        if (t1.size() != t2.size()) {
            throw new IllegalStateException("the size is not equals (" + t1.size() + ") != (" + t2.size() + ") ");
        }

        for (int i = 0; i < t1.size(); i++) {
            if (!t1.get(i).equals(t2.get(i))) {
                throw new IllegalStateException("t1 != t2 at index " + i + ", " + t1.get(i) + ", " + t2.get(i));
            }
        }
    }
}
