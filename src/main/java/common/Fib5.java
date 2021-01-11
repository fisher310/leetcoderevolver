package common;

import java.util.stream.IntStream;

/**
 * @author lihailong
 * @since 2021/1/7 0007
 */
public class Fib5 {

    private int last = 0, next = 1;

    public IntStream stream() {
        return IntStream.generate(
                () -> {
                    int oldLast = last;
                    last = next;
                    next = oldLast + next;
                    return oldLast;
                });
    }

    public static void main(String[] args) {
        Fib5 fib5 = new Fib5();
        fib5.stream().limit(41).forEachOrdered(System.out::println);

        System.out.println("========================");
        System.out.println(fib5.last);
        System.out.println(fib5.next);
    }
}
