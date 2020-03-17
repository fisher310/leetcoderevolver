package p1195;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.IntConsumer;

public class FizzBuzz {
    private int n;

    private AtomicInteger current;

    public FizzBuzz(int n) {
        this.n = n;
        this.current = new AtomicInteger(1);
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        while (current.get() <= n) {
            int x = current.get();
            if (x > n) {
                break;
            }

            if (x % 3 == 0 && x % 5 != 0) {
                printFizz.run();
                current.incrementAndGet();
            }
        }
        // System.out.println("finished fizz");
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        while (current.get() <= n) {
            int x = current.get();
            if (x > n) {
                break;
            }
            if (x % 3 != 0 && x % 5 == 0) {
                printBuzz.run();
                current.incrementAndGet();
            }
        }
        // System.out.println("finished buzz");
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        while (current.get() <= n) {
            int x = current.get();
            if (x > n) {
                break;
            }
            if (x % 3 == 0 && x % 5 == 0) {
                printFizzBuzz.run();
                current.incrementAndGet();
            }
        }
        // System.out.println("finished fizzbuzz");
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        while (current.get() <= n) {
            int x = current.get();
            if (x > n) {
                break;
            }

            if (x % 3 != 0 && x % 5 != 0) {
                printNumber.accept(x);
                current.incrementAndGet();
            }
        }
        // System.out.println("finished number");
    }

    public static void main(String[] args) throws InterruptedException {
        FizzBuzz fb = new FizzBuzz(15);
        Thread a = new Thread(() -> {
            try {
                fb.fizz(() -> {
                    System.out.println("fizz");
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread b = new Thread(() -> {
            try {
                fb.buzz(() -> {
                    System.out.println("buzz");
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread c = new Thread(() -> {
            try {
                fb.fizzbuzz(() -> {
                    System.out.println("fizzbuzz");
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread d = new Thread(() -> {
            try {
                fb.number(x -> {
                    System.out.println(x);
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        a.start();
        b.start();
        c.start();
        d.start();
        a.join();
        b.join();
        c.join();
        d.join();
    }
}
