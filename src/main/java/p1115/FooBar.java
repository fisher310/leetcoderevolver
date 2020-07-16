package p1115;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class FooBar {

    private int n;

    public FooBar(int n) {
        this.n = n;
    }

    private Lock lock = new ReentrantLock();

    private Condition cond1 = lock.newCondition();

    private Condition cond2 = lock.newCondition();

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {

            lock.lock();
            // printFoo.run() outputs "foo". Do not change or remove this line.
            try {
                printFoo.run();
                cond2.signal();
                cond1.await();

            } finally {
                lock.unlock();
            }

        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {

            lock.lock();
            // printBar.run() outputs "bar". Do not change or remove this line.
            try {

                printBar.run();
                cond1.signal();
                cond2.await();

            } finally {
                lock.unlock();
            }
        }
    }

}