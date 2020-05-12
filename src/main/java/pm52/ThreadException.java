package pm52;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadException {

    private ExecutorService executor;

    public ThreadException() {
        executor =
                new ThreadPoolExecutor(
                        2,
                        2,
                        0,
                        TimeUnit.SECONDS,
                        new ArrayBlockingQueue<>(1),

                        new ThreadPoolExecutor.CallerRunsPolicy());
    }

    public void execute() {
        for (int i = 0; i < 10; i++) {
            executor.submit(() -> {

                System.out.println(Thread.currentThread().getName() +  ", exec - " );
                throw new RuntimeException("asdf");
            });
        }
//        executor.shutdown();
    }

    public static void main(String[] args) {
        ThreadException test = new ThreadException();
        test.execute();
        System.out.println("+===================");
        test.execute();
    }
}
