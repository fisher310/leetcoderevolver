package common.concurrent;

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

            if (end - start < 10) {
                for (int i = start; i < end; i++) {
                    array[i] += adder;
                }
            } else {
                int split = start + (end - start) / 2;
                invokeAll(
                        new AddFork(array, start, split, adder),
                        new AddFork(array, split, end, adder));
            }
        }
    }

    public static void main(String[] args) {
        ForkJoinPool pool = new ForkJoinPool();

        int[] arr = new int[100];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
        pool.invoke(new AddFork(arr, 0, arr.length, 5));
        System.out.println(Arrays.toString(arr));
    }
}
