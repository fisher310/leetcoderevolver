package p1115;

import java.util.concurrent.Semaphore;

class FooBar {

    private int n;

    private Semaphore s1 = new Semaphore(1);
    private Semaphore s2 = new Semaphore(1);

    public FooBar(int n) {
        this.n = n;
        try {
            s2.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {

            // printFoo.run() outputs "foo". Do not change or remove this line.
            s1.acquire();
            printFoo.run();
            s2.release();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {

            // printBar.run() outputs "bar". Do not change or remove this line.

            s2.acquire();
            printBar.run();
            s1.release();
        }
    }

}