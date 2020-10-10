package util.test;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.VarHandle;
import java.util.concurrent.atomic.AtomicInteger;

public class T1 {

    public volatile int counter = 0;

    private static final VarHandle COUNTER;
    private volatile AtomicInteger k = new AtomicInteger(0);

    static {
        MethodHandles.Lookup lookup = MethodHandles.lookup();
        try {
            COUNTER = lookup.findVarHandle(T1.class, "counter", int.class);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ExceptionInInitializerError();
        }
    }

    public static void hello() {
        System.out.println("hello t1");
    }

    public void record(int v) {


        for (; ; ) {
            k.getAndIncrement();
            int expected = counter;
            int value = expected + v;
            if (COUNTER.compareAndSet(this, expected, value)) {
                return;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        T1 t1 = new T1();
        Thread thread1 = new Thread(()-> {
            for (int i = 0; i < 10000; i++)
                t1.record(1);
        });

        Thread thread2 = new Thread(() -> {
            for (int i =0; i < 10000; i++)
                t1.record(-1);
        });

        Thread thread3 = new Thread(() -> {
            for (int i =0; i < 10000; i++)
                t1.record(-1);
        });

        Thread thread4 = new Thread(() -> {
            for (int i =0; i < 10000; i++)
                t1.record(1);
        });


        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread1.join();
        thread2.join();
        thread3.join();
        thread4.join();
        System.out.println(t1.counter);
        System.out.println(t1.k.get());
    }
}
