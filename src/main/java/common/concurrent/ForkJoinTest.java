package common.concurrent;

import java.net.SocketTimeoutException;
import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

/**
 * @author lihailong
 * @since 2021/04/19 16:22:00
 */
public class ForkJoinTest {

    private static class AddFork extends RecursiveAction {

        private final int[] array;
        private final int start;
        private final int end;
        private final int adder;

        AddFork(int[] array, int start, int end, int adder) {
            this.array = array;
            this.start = start;
            this.end = end;
            this.adder = adder;
        }

        @Override
        protected void compute() {

            if (end - start < 5000) {
                for (int i = start; i < end; i++) {
                    array[i] += adder;
                }
            } else {
                int split = start + (end - start) / 2;
                new AddFork(array, start, split, adder).fork();
                new AddFork(array, split, end, adder).fork();
            }
        }
    }

    public static void main(String[] args) {
        ForkJoinPool pool = ForkJoinPool.commonPool();

        int[] arr = new int[100000000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
        long start = System.currentTimeMillis();
        pool.invoke(new AddFork(arr, 0, arr.length, 5));
        long duration = System.currentTimeMillis() - start;

        System.out.println("duration: " + duration);

        start = System.currentTimeMillis();
        for (int i = 0; i < arr.length; i++) {
            arr[i] += 5;
        }
        duration = System.currentTimeMillis() - start;

        System.out.println("loop duration: " + duration);
    }
}
