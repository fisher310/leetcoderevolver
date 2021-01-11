package test;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author lihailong
 * @since 2020/12/16 0016
 */
public class Test4 {

    private static volatile AtomicInteger num;

    public static void main(String[] args) throws InterruptedException {
        num = new AtomicInteger(1);

        Semaphore sa = new Semaphore(1);
        Semaphore sb = new Semaphore(0);
        Semaphore sc = new Semaphore(0);

        Thread t1 = new Thread(() -> {
            while (num.get() < 9) {
                try {
                    sa.acquire();
                    System.out.println("A->" + num.getAndIncrement());
                    sb.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread t2 = new Thread(() -> {
            while (num.get() < 9) {
                try {
                    sb.acquire();
                    System.out.println("B->" + num.getAndIncrement());
                    sc.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t3 = new Thread(() -> {
            while (num.get() < 9 ) {
                try {
                    sc.acquire();
                    System.out.println("C->" + num.getAndIncrement());
                    sa.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t1.start();
        t2.start();
        t3.start();
        t1.join();
        t2.join();
        t3.join();

    }
}
