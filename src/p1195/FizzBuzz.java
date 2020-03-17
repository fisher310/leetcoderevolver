package p1195;

import javax.sound.midi.Soundbank;
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
        }
        numberCondition.signal();
        fizzCondition.await();
      } finally {
        lock.unlock();
      }
    }
//    System.out.println("finished fizz");
  }

  // printBuzz.run() outputs "buzz".
  public void buzz(Runnable printBuzz) throws InterruptedException {
    while (current <= n) {
      lock.lock();
      try {
        if (current % 3 != 0 && current % 5 == 0) {
          printBuzz.run();
        }
        numberCondition.signal();
        buzzCondition.await();
      } finally {
        lock.unlock();
      }
    }
//    System.out.println("finished buzz");
  }

  // printFizzBuzz.run() outputs "fizzbuzz".
  public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
    while (current <= n) {
      lock.lock();
      try {
        if (current % 3 == 0 && current % 5 == 0) {
          printFizzBuzz.run();
        }
        numberCondition.signal();
        fizzBuzzCondition.signal();
        buzzCondition.signal();
        fizzBuzzCondition.await();
      } finally {
        lock.unlock();
      }
    }
//    System.out.println("finished fizzbuzz");
  }

  // printNumber.accept(x) outputs "x", where x is an integer.
  public void number(IntConsumer printNumber) throws InterruptedException {
    while (current <= n) {
      lock.lock();
      try {
        if (current % 3 != 0 && current % 5 != 0) {
          printNumber.accept(current);
        }
        current++;
        if (current > n) {
          fizzCondition.signal();
          buzzCondition.signal();
          fizzBuzzCondition.signal();
        } else if (current % 3 == 0 && current % 5 != 0) {
          fizzCondition.signal();
          numberCondition.await();
        } else if (current % 5 == 0 && current % 3 != 0) {
          buzzCondition.signal();
          numberCondition.await();
        } else if (current % 5 == 0 && current % 3 == 0) {
          fizzBuzzCondition.signal();
          numberCondition.await();
        }

      } finally {
        lock.unlock();
      }
    }
//    System.out.println("finished number");
  }

  public static void main(String[] args) throws InterruptedException {
    FizzBuzz fb = new FizzBuzz(6);
    Thread a =
        new Thread(
            () -> {
              try {
                fb.fizz(
                    () -> {
                      System.out.println("fizz");
                    });
              } catch (InterruptedException e) {
                e.printStackTrace();
              }
            });
    Thread b =
        new Thread(
            () -> {
              try {
                fb.buzz(
                    () -> {
                      System.out.println("buzz");
                    });
              } catch (InterruptedException e) {
                e.printStackTrace();
              }
            });

    Thread c =
        new Thread(
            () -> {
              try {
                fb.fizzbuzz(
                    () -> {
                      System.out.println("fizzbuzz");
                    });
              } catch (InterruptedException e) {
                e.printStackTrace();
              }
            });

    Thread d =
        new Thread(
            () -> {
              try {
                fb.number(
                    x -> {
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
