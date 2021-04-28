package common.concurrent;

import java.util.Arrays;
import java.util.OptionalInt;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * @author lihailong
 * @since 2021/04/19 16:22:00
 */
public class ForkJoinTest {

    private static class AddFork extends RecursiveTask<Long> {

        private final int[] array;
        private final int start;
        private final int end;
        private final int adder;
        private static final int THRESHOLD = 800000;

        AddFork(int[] array, int start, int end, int adder) {
            this.array = array;
            this.start = start;
            this.end = end;
            this.adder = adder;
        }

        @Override
        protected Long compute() {

            if (end - start < THRESHOLD) {
                long ans = 0;
                for (int i = start; i < end; i++) {
                    ans += array[i] * 2L + 1;
                }
                return ans;
            } else {
                int split = start + (end - start) / 2;
                AddFork left = new AddFork(array, start, split, adder);
                AddFork right = new AddFork(array, split, end, adder);
                left.fork();
                long r = right.compute();
                long l = left.join();
                return r + l;
            }
        }
    }

    public static void main(String[] args) {
        ForkJoinPool pool = ForkJoinPool.commonPool();
        Random random = new Random();

        int[] arr = new int[1600000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(100);
        }
        long start = System.currentTimeMillis();
        Long res = pool.invoke(new AddFork(arr, 0, arr.length, 5));
        long duration = System.currentTimeMillis() - start;

        System.out.println("duration: " + duration + ", ans=" + res);

        start = System.currentTimeMillis();
        long ans = 0;
        for (int j : arr) {
            ans += (j * 2L + 1);
        }
        duration = System.currentTimeMillis() - start;
        System.out.println("loop duration: " + duration + ", ans=" + ans);
    }
}
