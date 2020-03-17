package p1195;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;

public class FizzBuzz {
    private int n;

    private Lock lock;

    private int current;

    private Condition fizzCondition;

    private Condition buzzCondition;

    private Condition fizzBuzzCondition;

    private Condition numberCondition;

    public FizzBuzz(int n) {
        this.n = n;
        this.current = 1;
        lock = new ReentrantLock();
        fizzCondition = lock.newCondition();
        buzzCondition = lock.newCondition();
        fizzBuzzCondition = lock.newCondition();
        numberCondition = lock.newCondition();
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        while (current <= n) {
            lock.lock();
            try {
                if (current % 3 == 0 && current % 5 != 0) {
                    printFizz.run();
                } else {
                    fizzCondition.await();
                }
                numberCondition.signal();
            } finally {
                lock.unlock();
            }
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        while (current <= n) {
            lock.lock();
            try {
                if (current % 3 != 0 && current % 5 == 0) {
                    printBuzz.run();
                } else {
                    buzzCondition.await();
                }
                numberCondition.signal();
            } finally {
                lock.unlock();
            }
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {

        while (current <= n) {
            lock.lock();
            try {
                if (current % 3 == 0 && current % 5 == 0) {
                    printFizzBuzz.run();
                } else {
                    fizzBuzzCondition.await();
                }
                numberCondition.signal();
            } finally {
                lock.unlock();
            }
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        while(current <= n) {
            lock.lock();
            try {
                if(current %3 != 0 && current % 5 !=0) {
                    printNumber.accept(current++);
                } else if (current % 3 == 0){
                   fizzCondition.signal(); 
                } else if (current % 5 == 0) {
                    buzzCondition.signal();
                } else {
                    fizzBuzzCondition.signal();
                }
            } finally {
                lock.unlock();
            }
        }
    }
}